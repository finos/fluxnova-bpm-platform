package org.finos.fluxnova.bpm.engine.rest.security.auth.impl;

import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.rest.security.auth.AuthenticationProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Process Engine Plugin for JWT-based REST API authentication.
 * 
 * <p>This plugin enables OAuth2/OIDC JWT token validation for the Camunda REST API.
 * When enabled, it provides a {@link JwtAuthenticationProvider} that validates JWT tokens
 * using RS256 signature verification against a JWKS endpoint.</p>
 * 
 * <p><b>Configuration:</b> All configuration properties must be set on this plugin instance.
 * The plugin can be configured via:
 * <ul>
 *   <li>Spring Boot application.properties/yaml</li>
 *   <li>bpm-platform.xml (Tomcat/Wildfly)</li>
 *   <li>processes.xml (embedded engine)</li>
 *   <li>Programmatic configuration via setters</li>
 * </ul>
 * 
 * <p><b>Required Properties:</b>
 * <ul>
 *   <li><b>jwksUrl</b> - JWKS endpoint URL for signature verification (e.g., https://login.microsoft.../.well-known/jwks.json)</li>
 *   <li><b>issuer</b> - Expected token issuer (validates iss claim)</li>
 *   <li><b>audience</b> - Expected audience (validates aud claim)</li>
 *   <li><b>headerName</b> - HTTP header containing JWT (e.g., "Authorization")</li>
 *   <li><b>headerPrefix</b> - Token prefix in header (e.g., "Bearer", or "" for no prefix)</li>
 *   <li><b>userClaimName</b> - JWT claim name for user identity (e.g., "sub", "preferred_username")</li>
 * </ul>
 * 
 * <p><b>Optional Properties:</b>
 * <ul>
 *   <li><b>groupsClaimName</b> - JWT claim name for groups/roles (e.g., "groups", "roles"). Can be null.</li>
 * </ul>
 * 
 * <p><b>Spring Boot Example:</b>
 * <pre>
 * {@code
 * @Bean
 * public ProcessEnginePlugin jwtAuthenticationPlugin() {
 *   JwtAuthenticationPlugin plugin = new JwtAuthenticationPlugin();
 *   plugin.setJwksUrl("https://login.microsoftonline.com/{tenant}/discovery/v2.0/keys");
 *   plugin.setIssuer("https://login.microsoftonline.com/{tenant}/v2.0");
 *   plugin.setAudience("api://your-client-id");
 *   plugin.setHeaderName("Authorization");
 *   plugin.setHeaderPrefix("Bearer");
 *   plugin.setUserClaimName("preferred_username");
 *   plugin.setGroupsClaimName("groups");
 *   return plugin;
 * }
 * }
 * </pre>
 * 
 * <p><b>Usage:</b> After configuring the plugin, retrieve the authentication provider instance
 * via {@link #getAuthenticationProvider()} and configure it in your REST API authentication filter.</p>
 * 
 * @author Fluxnova Team
 */
public class JwtAuthenticationPlugin extends AbstractProcessEnginePlugin {

  private static final Logger LOG = Logger.getLogger(JwtAuthenticationPlugin.class.getName());

  private String jwksUrl;
  private String issuer;
  private String audience;
  private String headerName;
  private String headerPrefix;
  private String userClaimName;
  private String groupsClaimName;  // Optional

  private JwtAuthenticationProvider authenticationProvider;

  @Override
  public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
    // Initialize provider if not already done (e.g., via initializeProvider())
    if (authenticationProvider == null) {
      initializeProvider();
    }
    
    LOG.log(Level.INFO, "JWT Authentication Plugin initialized for engine: {0}", 
            processEngineConfiguration.getProcessEngineName());
  }
  
  /**
   * Initializes the JWT authentication provider with the configured settings.
   * This can be called explicitly (e.g., from Spring @Bean methods) or will be
   * called automatically during preInit() if not already initialized.
   * 
   * @throws IllegalStateException if required configuration is missing
   */
  public void initializeProvider() {
    validateConfiguration();
    
    this.authenticationProvider = new JwtAuthenticationProvider(
      jwksUrl,
      issuer,
      audience,
      headerName,
      headerPrefix,
      userClaimName,
      groupsClaimName
    );
  }

  @Override
  public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
    // Nothing to do
  }

  @Override
  public void postProcessEngineBuild(ProcessEngine processEngine) {
    // Nothing to do
  }

  /**
   * Returns the configured JWT authentication provider.
   * This should be used by the REST API authentication filter.
   * 
   * @return the authentication provider instance
   * @throws IllegalStateException if called before the plugin is initialized
   */
  public AuthenticationProvider getAuthenticationProvider() {
    if (authenticationProvider == null) {
      throw new IllegalStateException("JWT Authentication Plugin not initialized. Ensure the plugin is properly configured in the process engine.");
    }
    return authenticationProvider;
  }

  private void validateConfiguration() {
    if (jwksUrl == null || jwksUrl.trim().isEmpty()) {
      throw new IllegalArgumentException("JWT Authentication Plugin: jwksUrl is required");
    }
    if (issuer == null || issuer.trim().isEmpty()) {
      throw new IllegalArgumentException("JWT Authentication Plugin: issuer is required");
    }
    if (audience == null || audience.trim().isEmpty()) {
      throw new IllegalArgumentException("JWT Authentication Plugin: audience is required");
    }
    if (headerName == null || headerName.trim().isEmpty()) {
      throw new IllegalArgumentException("JWT Authentication Plugin: headerName is required");
    }
    if (headerPrefix == null) {  // Empty string is allowed for no prefix
      throw new IllegalArgumentException("JWT Authentication Plugin: headerPrefix is required (use empty string for no prefix)");
    }
    if (userClaimName == null || userClaimName.trim().isEmpty()) {
      throw new IllegalArgumentException("JWT Authentication Plugin: userClaimName is required");
    }
    // groupsClaimName is optional, can be null
  }

  // Getters and setters

  public String getJwksUrl() {
    return jwksUrl;
  }

  public void setJwksUrl(String jwksUrl) {
    this.jwksUrl = jwksUrl;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public String getAudience() {
    return audience;
  }

  public void setAudience(String audience) {
    this.audience = audience;
  }

  public String getHeaderName() {
    return headerName;
  }

  public void setHeaderName(String headerName) {
    this.headerName = headerName;
  }

  public String getHeaderPrefix() {
    return headerPrefix;
  }

  public void setHeaderPrefix(String headerPrefix) {
    this.headerPrefix = headerPrefix;
  }

  public String getUserClaimName() {
    return userClaimName;
  }

  public void setUserClaimName(String userClaimName) {
    this.userClaimName = userClaimName;
  }

  public String getGroupsClaimName() {
    return groupsClaimName;
  }

  public void setGroupsClaimName(String groupsClaimName) {
    this.groupsClaimName = groupsClaimName;
  }
}
