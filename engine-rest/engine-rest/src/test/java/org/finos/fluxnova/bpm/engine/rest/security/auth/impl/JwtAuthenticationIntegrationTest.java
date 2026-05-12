package org.finos.fluxnova.bpm.engine.rest.security.auth.impl;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.rest.security.auth.AuthenticationResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Integration tests for JWT authentication covering positive and negative cases
 * across different OAuth2/OIDC provider configurations.
 *
 * <p>Tests use an in-memory JWK set so no real HTTP calls are made to a JWKS endpoint.
 * This verifies the complete authentication flow: token parsing, signature verification,
 * claims validation, and user/group extraction.</p>
 */
public class JwtAuthenticationIntegrationTest {

  private static final String MOCK_ISSUER = "https://idp.example.com";
  private static final String MOCK_AUDIENCE = "my-app-client-id";
  private static final String TEST_KEY_ID = "integration-test-key";

  private HttpServletRequest request;
  private ProcessEngine engine;
  private RSAPrivateKey privateKey;
  private RSAPublicKey publicKey;

  @Before
  public void setUp() throws Exception {
    request = Mockito.mock(HttpServletRequest.class);
    engine = Mockito.mock(ProcessEngine.class);
    when(engine.getName()).thenReturn("default");

    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize(2048);
    KeyPair keyPair = gen.generateKeyPair();
    privateKey = (RSAPrivateKey) keyPair.getPrivate();
    publicKey = (RSAPublicKey) keyPair.getPublic();
  }


  @Test
  public void testValidTokenAuthenticatesUser() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    String token = createJWT("user123", "sub", futureDate(), null);
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Valid token should authenticate successfully", result.isAuthenticated());
    assertEquals("user123", result.getAuthenticatedUser());
  }

  @Test
  public void testValidTokenWithGroupsExtracted() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", "groups");
    String token = createJWT("user123", "sub", futureDate(), Arrays.asList("admins", "viewers"));
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Valid token with groups should authenticate", result.isAuthenticated());
    assertEquals("user123", result.getAuthenticatedUser());
    assertNotNull("Groups should be extracted", result.getGroups());
    assertTrue(result.getGroups().contains("admins"));
    assertTrue(result.getGroups().contains("viewers"));
  }

  @Test
  public void testValidTokenWithPreferredUsernameClaimEntraId() throws Exception {
    // Simulates Microsoft Entra ID (Azure AD) configuration
    JwtAuthenticationProvider provider = new JwtAuthenticationProvider(
        buildInMemoryProcessor(),
        "https://login.microsoftonline.com/tenant-id/v2.0",
        "app-client-id",
        "Authorization", "Bearer", "preferred_username", "roles"
    );
    String token = createJWT(
        "https://login.microsoftonline.com/tenant-id/v2.0",
        "app-client-id",
        "john.doe@company.com", "preferred_username",
        futureDate(), Arrays.asList("BPM-Admin", "BPM-User")
    );
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Entra ID token should authenticate", result.isAuthenticated());
    assertEquals("john.doe@company.com", result.getAuthenticatedUser());
    assertNotNull(result.getGroups());
    assertTrue(result.getGroups().contains("BPM-Admin"));
  }

  @Test
  public void testValidTokenWithEmailClaimAndNoPrefix() throws Exception {
    JwtAuthenticationProvider provider = new JwtAuthenticationProvider(
        buildInMemoryProcessor(),
        MOCK_ISSUER, MOCK_AUDIENCE,
        "X-Auth-Token", "", "email", null
    );
    String token = createJWT("user@example.com", "email", futureDate(), null);
    // No "Bearer " prefix - token is passed directly in header
    when(request.getHeader("X-Auth-Token")).thenReturn(token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Token with no prefix should authenticate", result.isAuthenticated());
    assertEquals("user@example.com", result.getAuthenticatedUser());
  }

  @Test
  public void testValidTokenWithNoGroupsClaimConfigured() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    String token = createJWT("user123", "sub", futureDate(), null);
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Should authenticate without groups configured", result.isAuthenticated());
    assertNull("Groups should be null when not configured", result.getGroups());
  }

  @Test
  public void testMissingTokenReturnsUnsuccessful() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    when(request.getHeader("Authorization")).thenReturn(null);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Missing token should not authenticate", result.isAuthenticated());
  }

  @Test
  public void testInvalidTokenFormatReturnsUnsuccessful() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    when(request.getHeader("Authorization")).thenReturn("Bearer not-a-jwt");

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Malformed token should not authenticate", result.isAuthenticated());
  }

  @Test
  public void testExpiredTokenReturnsUnsuccessful() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    String token = createJWT("user123", "sub", new Date(System.currentTimeMillis() - 3600000), null);
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Expired token should not authenticate", result.isAuthenticated());
  }

  @Test
  public void testWrongIssuerReturnsUnsuccessful() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    String token = createJWT(
        "https://evil-idp.example.com", MOCK_AUDIENCE,
        "user123", "sub", futureDate(), null
    );
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Wrong issuer should not authenticate", result.isAuthenticated());
  }

  @Test
  public void testWrongAudienceReturnsUnsuccessful() throws Exception {
    JwtAuthenticationProvider provider = createInMemoryProvider("sub", null);
    String token = createJWT(
        MOCK_ISSUER, "some-other-app",
        "user123", "sub", futureDate(), null
    );
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Wrong audience should not authenticate", result.isAuthenticated());
  }


  private JwtAuthenticationProvider createInMemoryProvider(String userClaim, String groupsClaim) throws Exception {
    return new JwtAuthenticationProvider(
        buildInMemoryProcessor(),
        MOCK_ISSUER, MOCK_AUDIENCE,
        "Authorization", "Bearer", userClaim, groupsClaim
    );
  }

  private ConfigurableJWTProcessor<SecurityContext> buildInMemoryProcessor() throws Exception {
    RSAKey jwk = new RSAKey.Builder(publicKey).keyID(TEST_KEY_ID).build();
    ImmutableJWKSet<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
    Set<JWSAlgorithm> algorithms = new HashSet<>(Arrays.asList(JWSAlgorithm.RS256));
    ConfigurableJWTProcessor<SecurityContext> processor = new DefaultJWTProcessor<>();
    processor.setJWSKeySelector(new JWSVerificationKeySelector<>(algorithms, jwkSource));
    return processor;
  }

  private String createJWT(String userId, String userClaimName, Date expiration, List<String> groups) throws Exception {
    return createJWT(MOCK_ISSUER, MOCK_AUDIENCE, userId, userClaimName, expiration, groups);
  }

  private String createJWT(String issuer, String audience, String userId, String userClaimName,
                            Date expiration, List<String> groups) throws Exception {
    JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
        .subject(userId)
        .issuer(issuer)
        .audience(List.of(audience))
        .expirationTime(expiration)
        .issueTime(new Date())
        .claim(userClaimName, userId);
    if (groups != null) {
      builder.claim("groups", groups).claim("roles", groups);
    }
    SignedJWT signedJWT = new SignedJWT(
        new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(TEST_KEY_ID).build(),
        builder.build()
    );
    signedJWT.sign(new RSASSASigner(privateKey));
    return signedJWT.serialize();
  }

  private static Date futureDate() {
    return new Date(System.currentTimeMillis() + 3600000);
  }
}
