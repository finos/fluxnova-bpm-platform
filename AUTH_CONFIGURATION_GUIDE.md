# Fluxnova Authentication Configuration Guide

## Summary of the auth changes

The recent auth work introduced runtime-selectable REST authentication for both `starter-rest` and `distro/run` so applications no longer need to be recompiled to switch between authentication modes.

### What changed

1. **JWT auto-configuration was added to `starter-rest`**
   - Spring Boot apps can configure JWT/OIDC authentication through properties and environment variables instead of custom Java `@Configuration`.

2. **`distro/run` was extended to support JWT**
   - `distro/run` can now switch between `basic` and `jwt` auth at runtime using environment variables.

3. **Starter-rest now has auth-mode parity with `distro/run`**
   - `starter-rest` now supports:
     - `basic`
     - `jwt`
   - Selection happens at runtime through `fluxnova.bpm.auth.*`.

4. **Basic auth remains dependency-free**
   - No new required dependencies were added for basic auth.

5. **JWT remains optional**
   - JWT still depends on `nimbus-jose-jwt`, and that dependency remains optional.

6. **Shared wiring was extracted**
   - The common JWT/basic filter setup is now shared so `starter-rest` and `distro/run` do not duplicate the same logic.

7. **Header prefix behavior was fixed**
   - JWT header prefix normalization now auto-appends the required trailing space instead of throwing when `"Bearer"` is configured without a space.

---

## Current configuration model

There are now two main runtime configuration models:

### 1. `starter-rest` Spring Boot applications

Use:

- `fluxnova.bpm.auth.enabled`
- `fluxnova.bpm.auth.type`
- `fluxnova.bpm.jwt.*` for JWT-specific settings

### 2. `distro/run`

Use:

- `fluxnova.bpm.run.auth.enabled`
- `fluxnova.bpm.run.auth.authentication`
- `fluxnova.bpm.jwt.*` for JWT-specific settings

---

## Current configuration examples

## Starter-rest: basic auth

### Environment variables

```bash
FLUXNOVA_BPM_AUTH_ENABLED=true
```

This enables REST authentication and defaults to `basic`.

Explicit form:

```bash
FLUXNOVA_BPM_AUTH_ENABLED=true
FLUXNOVA_BPM_AUTH_TYPE=basic
```

### application.yml

```yaml
fluxnova:
  bpm:
    auth:
      enabled: true
      type: basic
```

### Credential source

Basic auth still uses the configured identity source. For the built-in admin user, that is typically:

```bash
FLUXNOVA_BPM_ADMIN_USER_ID=demo
FLUXNOVA_BPM_ADMIN_USER_PASSWORD=demo
```

---

## Starter-rest: JWT auth

### Environment variables

```bash
FLUXNOVA_BPM_AUTH_ENABLED=true
FLUXNOVA_BPM_AUTH_TYPE=jwt
FLUXNOVA_BPM_JWT_JWKS_URL=https://login.microsoftonline.com/<tenant>/discovery/v2.0/keys
FLUXNOVA_BPM_JWT_ISSUER=https://login.microsoftonline.com/<tenant>/v2.0
FLUXNOVA_BPM_JWT_AUDIENCE=api://your-client-id
```

Optional JWT variables:

```bash
FLUXNOVA_BPM_JWT_USER_CLAIM_NAME=preferred_username
FLUXNOVA_BPM_JWT_GROUPS_CLAIM_NAME=groups
FLUXNOVA_BPM_JWT_HEADER_NAME=Authorization
FLUXNOVA_BPM_JWT_HEADER_PREFIX=Bearer
```

### application.yml

```yaml
fluxnova:
  bpm:
    auth:
      enabled: true
      type: jwt
    jwt:
      jwks-url: https://login.microsoftonline.com/<tenant>/discovery/v2.0/keys
      issuer: https://login.microsoftonline.com/<tenant>/v2.0
      audience: api://your-client-id
      user-claim-name: preferred_username
      groups-claim-name: groups
      header-name: Authorization
      header-prefix: Bearer
```

---

## Distro/run: basic auth

### Environment variables

```bash
FLUXNOVA_BPM_RUN_AUTH_ENABLED=true
```

Explicit form:

```bash
FLUXNOVA_BPM_RUN_AUTH_ENABLED=true
FLUXNOVA_BPM_RUN_AUTH_AUTHENTICATION=basic
```

### application.yml

```yaml
fluxnova:
  bpm:
    run:
      auth:
        enabled: true
        authentication: basic
```

### Credential source

As with starter-rest, this authenticates against the configured identity source. For the built-in admin user:

```bash
FLUXNOVA_BPM_ADMIN_USER_ID=demo
FLUXNOVA_BPM_ADMIN_USER_PASSWORD=demo
```

---

## Distro/run: JWT auth

### Environment variables

```bash
FLUXNOVA_BPM_RUN_AUTH_ENABLED=true
FLUXNOVA_BPM_RUN_AUTH_AUTHENTICATION=jwt
FLUXNOVA_BPM_JWT_JWKS_URL=https://login.microsoftonline.com/<tenant>/discovery/v2.0/keys
FLUXNOVA_BPM_JWT_ISSUER=https://login.microsoftonline.com/<tenant>/v2.0
FLUXNOVA_BPM_JWT_AUDIENCE=api://your-client-id
```

Optional:

```bash
FLUXNOVA_BPM_JWT_USER_CLAIM_NAME=preferred_username
FLUXNOVA_BPM_JWT_GROUPS_CLAIM_NAME=groups
FLUXNOVA_BPM_JWT_HEADER_NAME=Authorization
FLUXNOVA_BPM_JWT_HEADER_PREFIX=Bearer
```

### application.yml

```yaml
fluxnova:
  bpm:
    run:
      auth:
        enabled: true
        authentication: jwt
    jwt:
      jwks-url: https://login.microsoftonline.com/<tenant>/discovery/v2.0/keys
      issuer: https://login.microsoftonline.com/<tenant>/v2.0
      audience: api://your-client-id
      user-claim-name: preferred_username
      groups-claim-name: groups
```

---

## Legacy configuration examples

These are the old approaches that existed before the new parity work.

## Legacy starter-rest JWT: custom Java configuration

Originally, JWT auth for Spring Boot required application code similar to:

```java
@Configuration
public class JwtAuthConfiguration {

  @Bean
  public JwtAuthenticationPlugin jwtAuthenticationPlugin() {
    JwtAuthenticationPlugin plugin = new JwtAuthenticationPlugin();
    plugin.setJwksUrl("https://idp.example.com/.well-known/jwks.json");
    plugin.setIssuer("https://idp.example.com");
    plugin.setAudience("api://your-client-id");
    plugin.initializeProvider();
    return plugin;
  }

  @Bean
  public FilterRegistrationBean<ProcessEngineAuthenticationFilter> processEngineAuthenticationFilter(
      JwtAuthenticationPlugin plugin) {
    ProcessEngineAuthenticationFilter filter = new ProcessEngineAuthenticationFilter();
    filter.setAuthenticationProvider(plugin.getAuthenticationProvider());

    FilterRegistrationBean<ProcessEngineAuthenticationFilter> registration =
        new FilterRegistrationBean<>(filter);
    registration.addUrlPatterns("/engine-rest/*");
    registration.setOrder(1);
    return registration;
  }
}
```

This required a rebuild whenever the JWT provider settings changed.

---
