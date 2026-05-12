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
import javax.servlet.http.HttpServletResponse;
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


public class JwtAuthenticationProviderTest {

  private static final String TEST_JWKS_URL = "https://idp.example.com/.well-known/jwks.json";
  private static final String TEST_ISSUER = "https://idp.example.com";
  private static final String TEST_AUDIENCE = "test-client-id";
  private static final String TEST_USER_ID = "test-user";
  private static final String TEST_KEY_ID = "test-key-1";

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ProcessEngine engine;
  private RSAPrivateKey privateKey;
  private RSAPublicKey publicKey;

  @Before
  public void setUp() throws Exception {
    request = Mockito.mock(HttpServletRequest.class);
    response = Mockito.mock(HttpServletResponse.class);
    engine = Mockito.mock(ProcessEngine.class);
    when(engine.getName()).thenReturn("default");

    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize(2048);
    KeyPair keyPair = gen.generateKeyPair();
    privateKey = (RSAPrivateKey) keyPair.getPrivate();
    publicKey = (RSAPublicKey) keyPair.getPublic();
  }

  @Test
  public void testMissingToken() {
    when(request.getHeader("Authorization")).thenReturn(null);
    JwtAuthenticationProvider provider = createProvider();

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Should fail when token is missing", result.isAuthenticated());
  }

  @Test
  public void testInvalidTokenFormat() {
    when(request.getHeader("Authorization")).thenReturn("InvalidTokenFormat");
    JwtAuthenticationProvider provider = createProvider();

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Should fail with invalid token format", result.isAuthenticated());
  }

  @Test
  public void testTokenWithoutBearerPrefix() {
    when(request.getHeader("Authorization")).thenReturn("SomeToken");
    JwtAuthenticationProvider provider = createProvider();

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Should fail without Bearer prefix", result.isAuthenticated());
  }

  @Test
  public void testExpiredToken() throws Exception {
    Date pastDate = new Date(System.currentTimeMillis() - 3600000); // 1 hour ago
    String token = createSignedJWT(pastDate, null);
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
    JwtAuthenticationProvider provider = createProvider();

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertFalse("Should fail with expired token", result.isAuthenticated());
  }

  @Test
  public void testValidTokenAuthenticatesSuccessfully() throws Exception {
    Date futureDate = new Date(System.currentTimeMillis() + 3600000);
    String token = createSignedJWT(futureDate, null);
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
    JwtAuthenticationProvider provider = createProviderWithInMemoryJwks("sub", null);

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Valid JWT should authenticate successfully", result.isAuthenticated());
    assertEquals("User ID should match sub claim", TEST_USER_ID, result.getAuthenticatedUser());
  }

  @Test
  public void testValidTokenWithGroupsExtracted() throws Exception {
    Date futureDate = new Date(System.currentTimeMillis() + 3600000);
    String token = createSignedJWT(futureDate, Arrays.asList("group-a", "group-b"));
    when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
    JwtAuthenticationProvider provider = createProviderWithInMemoryJwks("sub", "groups");

    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);

    assertTrue("Valid JWT with groups should authenticate", result.isAuthenticated());
    assertEquals(TEST_USER_ID, result.getAuthenticatedUser());
    assertNotNull("Groups should be extracted", result.getGroups());
    assertTrue("Should contain group-a", result.getGroups().contains("group-a"));
    assertTrue("Should contain group-b", result.getGroups().contains("group-b"));
  }

  @Test
  public void testAugmentResponse() {
    JwtAuthenticationProvider provider = createProvider();

    provider.augmentResponseByAuthenticationChallenge(response, engine);

    Mockito.verify(response).setHeader("WWW-Authenticate", "Bearer realm=\"default\"");
  }

  @Test
  public void testCustomHeaderConfiguration() {
    when(request.getHeader("X-Auth-Token")).thenReturn("CustomPrefix mytoken");
    JwtAuthenticationProvider provider = new JwtAuthenticationProvider(
        TEST_JWKS_URL, TEST_ISSUER, TEST_AUDIENCE,
        "X-Auth-Token", "CustomPrefix", "sub", null
    );
    AuthenticationResult result = provider.extractAuthenticatedUser(request, engine);
    assertFalse(result.isAuthenticated());
  }


  private JwtAuthenticationProvider createProvider() {
    return new JwtAuthenticationProvider(
        TEST_JWKS_URL, TEST_ISSUER, TEST_AUDIENCE,
        "Authorization", "Bearer", "sub", null
    );
  }

  /**
   * Creates a provider backed by an in-memory JWK set so no HTTP call is made.
   * This enables genuine positive testing of the full authentication flow.
   */
  private JwtAuthenticationProvider createProviderWithInMemoryJwks(String userClaim, String groupsClaim) throws Exception {
    RSAKey jwk = new RSAKey.Builder(publicKey).keyID(TEST_KEY_ID).build();
    ImmutableJWKSet<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));

    Set<JWSAlgorithm> algorithms = new HashSet<>(Arrays.asList(JWSAlgorithm.RS256));
    ConfigurableJWTProcessor<SecurityContext> processor = new DefaultJWTProcessor<>();
    processor.setJWSKeySelector(new JWSVerificationKeySelector<>(algorithms, jwkSource));

    return new JwtAuthenticationProvider(processor, TEST_ISSUER, TEST_AUDIENCE,
        "Authorization", "Bearer", userClaim, groupsClaim);
  }

  private String createSignedJWT(Date expiration, List<String> groups) throws Exception {
    JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
        .subject(TEST_USER_ID)
        .issuer(TEST_ISSUER)
        .audience(List.of(TEST_AUDIENCE))
        .expirationTime(expiration)
        .issueTime(new Date());
    if (groups != null) {
      builder.claim("groups", groups);
    }

    SignedJWT signedJWT = new SignedJWT(
        new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(TEST_KEY_ID).build(),
        builder.build()
    );
    signedJWT.sign(new RSASSASigner(privateKey));
    return signedJWT.serialize();
  }
}
