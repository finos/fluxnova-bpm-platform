package org.finos.fluxnova.bpm.engine.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.finos.fluxnova.bpm.engine.rest.dto.ModificationDto;
import org.junit.jupiter.api.Test;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

/**
 * Regression tests for the 3.0.1 hotfix that disabled {@code FAIL_ON_NULL_FOR_PRIMITIVES},
 * which allows request payloads to send {@code null} for optional primitive fields
 * (e.g. {@code skipCustomListeners}, {@code skipIoMappings}) instead of failing deserialization.
 */
public class JacksonConfiguratorTest {

  @Test
  public void shouldDisableFailOnNullForPrimitivesAndUnknownProperties() {
    ObjectMapper mapper = JacksonConfigurator.configureObjectMapper();

    assertThat(mapper.deserializationConfig().isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)).isFalse();
    assertThat(mapper.deserializationConfig().isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)).isFalse();
  }

  @Test
  public void shouldDeserializeNullForPrimitiveBooleanField() {
    ObjectMapper mapper = JacksonConfigurator.configureObjectMapper();

    ModificationDto dto = mapper.readValue("{\"skipCustomListeners\":null,\"skipIoMappings\":null}", ModificationDto.class);

    assertThat(dto.isSkipCustomListeners()).isFalse();
    assertThat(dto.isSkipIoMappings()).isFalse();
  }

  @Test
  public void shouldFailOnNullForPrimitivesWhenFeatureReenabled() {
    // sanity check: proves the test above actually exercises the hotfix setting, not a no-op
    ObjectMapper strictMapper = JsonMapper.builder()
        .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        .build();

    assertThatThrownBy(() -> strictMapper.readValue("{\"skipCustomListeners\":null}", ModificationDto.class))
        .isInstanceOf(Exception.class);
  }

}
