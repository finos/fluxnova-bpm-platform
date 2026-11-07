package org.finos.fluxnova.bpm.spring.boot.starter.security.oauth2.impl;

import java.util.Collections;
import java.util.Map;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Condition that matches if any {@code spring.security.oauth2.client.registration} properties are defined.
 * Replaces {@code org.springframework.boot.security.oauth2.client.autoconfigure.ClientsConfiguredCondition}
 * which became package-private in Spring Boot 4.
 */
public class ClientsConfiguredCondition extends SpringBootCondition {

  @Override
  public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Map<String, Object> registrations = Binder.get(context.getEnvironment())
        .bind("spring.security.oauth2.client.registration", Bindable.mapOf(String.class, Object.class))
        .orElse(Collections.emptyMap());

    if (!registrations.isEmpty()) {
      return ConditionOutcome.match("OAuth2 client registrations are configured");
    }
    return ConditionOutcome.noMatch("No OAuth2 client registrations configured");
  }

}

