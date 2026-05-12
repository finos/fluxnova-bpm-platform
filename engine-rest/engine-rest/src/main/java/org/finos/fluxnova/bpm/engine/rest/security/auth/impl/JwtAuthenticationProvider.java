package org.finos.fluxnova.bpm.engine.rest.security.auth.impl;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.rest.security.auth.AuthenticationProvider;
import org.finos.fluxnova.bpm.engine.rest.security.auth.AuthenticationResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Authentication provider for OAuth2/OIDC JWT tokens.
 * 
 * <p>This provider validates JWT tokens issued by OAuth2/OIDC providers (e.g., Microsoft Entra ID,
 * Keycloak, Auth0, Okta). The validation includes:
 * <ul>
 *   <li>Signature verification using RS256 algorithm with public keys from JWKS endpoint</li>
 *   <li>Token expiration (exp claim) validation</li>
 *   <li>Issuer (iss claim) validation</li>
 *   <li>Audience (aud claim) validation</li>
 * </ul>
 * 
 * <p><b>Configuration:</b> This provider is typically configured via the {@link JwtAuthenticationPlugin}
 * which is enabled as a process engine plugin. All configuration is passed via constructor parameters.
 * 
 * <p><b>Note:</b> The prefix is automatically normalized - if you specify "Bearer", a space 
 * is added automatically so you don't need to include it in configuration. Use empty string 
 * for no prefix.
 * 
 * <p><b>User Identity Extraction:</b>
 * The provider extracts user identity from a configurable claim (e.g., "sub", "preferred_username").
 * Groups can optionally be extracted if a groups claim name is provided.
 * 
 * @author Fluxnova Team
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private static final Logger LOG = Logger.getLogger(JwtAuthenticationProvider.class.getName());

  private final ConfigurableJWTProcessor<SecurityContext> jwtProcessor;
  private final String expectedIssuer;
  private final String expectedAudience;
  private final String headerName;
  private final String headerPrefix;
  private final String userClaimName;
  private final String groupsClaimName;  // Optional

  /**
   * Creates provider with explicit configuration. This is typically called by {@link JwtAuthenticationPlugin}.
   * 
   * @param jwksUrl JWKS endpoint URL for signature verification
   * @param expectedIssuer expected issuer claim value
   * @param expectedAudience expected audience claim value
   * @param headerName HTTP header name containing token
   * @param headerPrefix token prefix in header (e.g., "Bearer" - space will be added automatically if needed)
   * @param userClaimName JWT claim name for user identity
   * @param groupsClaimName (Optional) JWT claim name for groups - can be null
   */
  public JwtAuthenticationProvider(String jwksUrl, String expectedIssuer, String expectedAudience,
                                     String headerName, String headerPrefix, String userClaimName, String groupsClaimName) {
    this.expectedIssuer = expectedIssuer;
    this.expectedAudience = expectedAudience;
    this.headerName = headerName;
    this.headerPrefix = normalizePrefix(headerPrefix);
    this.userClaimName = userClaimName;
    this.groupsClaimName = groupsClaimName;  // Can be null
    
    this.jwtProcessor = createJwtProcessor(jwksUrl);
    
    LOG.log(Level.INFO, "Initialized JWT authentication provider with JWKS URL: {0}", jwksUrl);
  }

  /**
   * Package-private constructor for testing - accepts a pre-built JWT processor.
   * This avoids HTTP calls to a real JWKS endpoint in unit/integration tests.
   * Use {@code ImmutableJWKSet} from Nimbus to supply in-memory keys.
   */
  JwtAuthenticationProvider(ConfigurableJWTProcessor<SecurityContext> jwtProcessor,
                              String expectedIssuer, String expectedAudience,
                              String headerName, String headerPrefix,
                              String userClaimName, String groupsClaimName) {
    this.jwtProcessor = jwtProcessor;
    this.expectedIssuer = expectedIssuer;
    this.expectedAudience = expectedAudience;
    this.headerName = headerName;
    this.headerPrefix = normalizePrefix(headerPrefix);
    this.userClaimName = userClaimName;
    this.groupsClaimName = groupsClaimName;
  }

  @Override
  public AuthenticationResult extractAuthenticatedUser(HttpServletRequest request, ProcessEngine engine) {
    try {
      String token = extractToken(request);
      if (token == null) {
        LOG.log(Level.FINE, "No JWT token found in request");
        return AuthenticationResult.unsuccessful();
      }

      JWTClaimsSet claims = jwtProcessor.process(token, null);

      if (!expectedIssuer.equals(claims.getIssuer())) {
        LOG.log(Level.WARNING, "Invalid issuer: {0}, expected: {1}", 
            new Object[]{claims.getIssuer(), expectedIssuer});
        return AuthenticationResult.unsuccessful();
      }

      List<String> audience = claims.getAudience();
      if (audience == null || !audience.contains(expectedAudience)) {
        LOG.log(Level.WARNING, "Invalid audience: {0}, expected: {1}", 
            new Object[]{audience, expectedAudience});
        return AuthenticationResult.unsuccessful();
      }

      String userId = claims.getStringClaim(userClaimName);
      if (userId == null || userId.isEmpty()) {
        LOG.log(Level.WARNING, "Missing or empty user claim: {0}", userClaimName);
        return AuthenticationResult.unsuccessful();
      }

      LOG.log(Level.INFO, "Successfully authenticated user: {0}", userId);
      
      List<String> groups = extractGroups(claims);

      AuthenticationResult result = new AuthenticationResult(userId, true);
      result.setGroups(groups);
      return result;

    } catch (Exception e) {
      LOG.log(Level.WARNING, "JWT authentication failed", e);
      return AuthenticationResult.unsuccessful();
    }
  }

  @Override
  public void augmentResponseByAuthenticationChallenge(HttpServletResponse response, ProcessEngine engine) {
    response.setHeader("WWW-Authenticate", "Bearer realm=\"" + engine.getName() + "\"");
  }

  /**
   * Extracts JWT token from HTTP request header.
   */
  private String extractToken(HttpServletRequest request) {
    String header = request.getHeader(headerName);
    if (header == null || !header.startsWith(headerPrefix)) {
      return null;
    }
    return header.substring(headerPrefix.length()).trim();
  }

  /**
   * Extracts groups from JWT claims if groups claim is configured.
   */
  private List<String> extractGroups(JWTClaimsSet claims) {
    if (groupsClaimName == null || groupsClaimName.trim().isEmpty()) {
      return null;  // Groups claim not configured
    }
    try {
      return claims.getStringListClaim(groupsClaimName);
    } catch (Exception e) {
      LOG.log(Level.FINE, "No groups claim ''{0}'' found in token", groupsClaimName);
      return null;
    }
  }

  /**
   * Creates and configures JWT processor for validation.
   */
  private ConfigurableJWTProcessor<SecurityContext> createJwtProcessor(String jwksUrl) {
    try {
      ConfigurableJWTProcessor<SecurityContext> processor = new DefaultJWTProcessor<>();

      JWKSource<SecurityContext> keySource = new RemoteJWKSet<>(new URL(jwksUrl));

      Set<JWSAlgorithm> expectedAlgorithms = new HashSet<>(Arrays.asList(JWSAlgorithm.RS256));
      JWSKeySelector<SecurityContext> keySelector = 
          new JWSVerificationKeySelector<>(expectedAlgorithms, keySource);
      processor.setJWSKeySelector(keySelector);

      return processor;
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize JWT processor with JWKS URL: " + jwksUrl, e);
    }
  }

  /**
   * Normalizes the token prefix to ensure proper spacing.
   * - Empty string or null: returns empty string (no prefix)
   * - Non-empty prefix without trailing space: adds space automatically
   * - Prefix already has trailing space: returns as-is
   * This prevents configuration errors where users forget the space after "Bearer"
   */
  private static String normalizePrefix(String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return "";
    }
    if (!prefix.endsWith(" ")) {
      return prefix + " ";
    }
    return prefix;
  }
}
