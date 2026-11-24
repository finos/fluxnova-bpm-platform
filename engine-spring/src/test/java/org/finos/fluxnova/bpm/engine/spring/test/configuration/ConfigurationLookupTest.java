package org.finos.fluxnova.bpm.engine.spring.test.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.spring.configuration.ConfigurationLookup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConfigurationLookupTest {

  private final DelegateExecution execution = mock(DelegateExecution.class);
  private final ProcessEngine engine = mock(ProcessEngine.class);
  private final ConfigurationService service = mock(ConfigurationService.class);
  private final ConfigurationLookup lookup = new ConfigurationLookup();

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = "tenant-a")
  void returnsMatchingActiveValueFromExecutingEngine(String tenantId) {
    when(execution.getProcessEngine()).thenReturn(engine);
    when(engine.getConfigurationService()).thenReturn(service);
    Configuration other = configuration("other", "ignored");
    Configuration expected = configuration("feature.flag", "enabled");
    when(service.getConfigurations(tenantId, false)).thenReturn(List.of(other, expected));

    assertThat(lookup.getValue(execution, "feature.flag", tenantId)).isEqualTo("enabled");

    verify(service).getConfigurations(tenantId, false);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = "tenant-a")
  void failsWhenNoActiveConfigurationMatches(String tenantId) {
    when(execution.getProcessEngine()).thenReturn(engine);
    when(engine.getConfigurationService()).thenReturn(service);
    Configuration other = configuration("other", "ignored");
    when(service.getConfigurations(tenantId, false)).thenReturn(List.of(other));

    assertThatThrownBy(() -> lookup.getValue(execution, "missing", tenantId))
        .isInstanceOf(NotFoundException.class)
        .hasMessage("No active configuration found for key 'missing' in "
            + (tenantId == null ? "global scope" : "tenant 'tenant-a'"));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = " ")
  void rejectsMissingOrBlankKey(String key) {
    assertThatThrownBy(() -> lookup.getValue(execution, key, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("configKey must be a non-blank string");

    verifyNoInteractions(execution, service);
  }

  @ParameterizedTest
  @ValueSource(strings = { "", " " })
  void rejectsBlankTenant(String tenantId) {
    assertThatThrownBy(() -> lookup.getValue(execution, "feature.flag", tenantId))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("tenantId must be a non-blank string");

    verifyNoInteractions(execution, service);
  }

  @ParameterizedTest
  @ValueSource(ints = 42)
  void rejectsNonStringTenant(int tenantId) {
    assertThatThrownBy(() -> lookup.getValue(execution, "feature.flag", tenantId))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("tenantId must be a non-blank string");

    verifyNoInteractions(execution, service);
  }

  private Configuration configuration(String key, String value) {
    Configuration configuration = mock(Configuration.class);
    when(configuration.getConfigKey()).thenReturn(key);
    when(configuration.getConfigValue()).thenReturn(value);
    return configuration;
  }
}
