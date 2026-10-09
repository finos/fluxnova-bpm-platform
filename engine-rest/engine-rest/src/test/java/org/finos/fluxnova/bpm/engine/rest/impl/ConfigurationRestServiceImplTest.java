package org.finos.fluxnova.bpm.engine.rest.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEnginePersistenceException;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationEntity;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.ConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.CreateConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.UpdateConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tools.jackson.databind.ObjectMapper;

/**
 * Unit tests for {@link ConfigurationRestServiceImpl}.
 *
 * <p>A mock {@link ConfigurationService} is injected through a test subclass so that
 * no process engine or database is required. Persistence behaviour is covered by the
 * engine level tests.</p>
 */
class ConfigurationRestServiceImplTest {

  private ConfigurationService configurationService;
  private UriInfo uriInfo;
  private ProcessEngine processEngine;

  private TestableConfigurationRestServiceImpl service;

  @BeforeEach
  void setUp() {
    configurationService = mock(ConfigurationService.class);
    uriInfo = mock(UriInfo.class);
    processEngine = mock(ProcessEngine.class);

    UriBuilder uriBuilder = mock(UriBuilder.class);
    when(uriInfo.getBaseUriBuilder()).thenReturn(uriBuilder);
    when(uriBuilder.path(anyString())).thenReturn(uriBuilder);
    when(uriBuilder.build()).thenReturn(URI.create("http://localhost/engine-rest/configurations/test-id"));

    when(processEngine.getConfigurationService()).thenReturn(configurationService);

    service = new TestableConfigurationRestServiceImpl(processEngine, new ObjectMapper());
  }

  protected static ConfigurationEntity newConfiguration(String key, String value, String tenantId) {
    ConfigurationEntity entity = new ConfigurationEntity();
    entity.setId("test-id");
    entity.setConfigKey(key);
    entity.setConfigValue(value);
    entity.setTenantId(tenantId);
    entity.setVersion(1);
    entity.setStatus(Configuration.STATUS_ACTIVE);
    entity.setCreatedBy("demo");
    entity.setCreatedAt(new Date());
    return entity;
  }

  @Test
  void shouldCreateGlobalConfiguration() {
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), isNull()))
        .thenReturn(newConfiguration("my.key", "my-value", null));

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("my.key");
    dto.setConfigValue("my-value");

    Response response = service.createConfiguration(dto, uriInfo);

    assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
    assertNotNull(response.getLocation());

    ConfigurationDto result = (ConfigurationDto) response.getEntity();
    assertEquals("test-id", result.getId());
    assertEquals("my.key", result.getConfigKey());
    assertEquals("my-value", result.getConfigValue());
    assertEquals(Configuration.STATUS_ACTIVE, result.getStatus());

    verify(configurationService).createConfiguration("my.key", "my-value", null);
  }

  @Test
  void shouldCreateTenantScopedConfiguration() {
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), eq("tenant-1")))
        .thenReturn(newConfiguration("my.key", "my-value", "tenant-1"));

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("my.key");
    dto.setConfigValue("my-value");
    dto.setTenantId("tenant-1");

    Response response = service.createConfiguration(dto, uriInfo);

    assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
    assertEquals("tenant-1", ((ConfigurationDto) response.getEntity()).getTenantId());
  }

  @Test
  void shouldTrimBlankTenantIdToNull() {
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), isNull()))
        .thenReturn(newConfiguration("my.key", "my-value", null));

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("  my.key  ");
    dto.setConfigValue("my-value");
    dto.setTenantId("   ");

    service.createConfiguration(dto, uriInfo);

    verify(configurationService).createConfiguration("my.key", "my-value", null);
  }

  @Test
  void shouldGetGlobalActiveConfigurationsWhenTenantIdIsMissing() {
    ConfigurationEntity configuration = newConfiguration("my.key", "my-value", null);
    when(configurationService.getConfigurations(isNull(), eq(false))).thenReturn(Arrays.asList(configuration));

    List<ConfigurationDto> result = service.getConfigurations(null, null);

    assertEquals(1, result.size());
    assertEquals("my.key", result.get(0).getConfigKey());
    assertEquals("my-value", result.get(0).getConfigValue());
    assertNull(result.get(0).getTenantId());
    verify(configurationService).getConfigurations(null, false);
  }

  @Test
  void shouldGetTenantConfigurations() {
    ConfigurationEntity configuration = newConfiguration("my.key", "my-value", "tenant-1");
    when(configurationService.getConfigurations(eq("tenant-1"), eq(false))).thenReturn(Arrays.asList(configuration));

    List<ConfigurationDto> result = service.getConfigurations(" tenant-1 ", false);

    assertEquals(1, result.size());
    assertEquals("tenant-1", result.get(0).getTenantId());
    verify(configurationService).getConfigurations("tenant-1", false);
  }

  @Test
  void shouldIncludeInactiveConfigurationsWhenRequested() {
    ConfigurationEntity inactiveConfiguration = newConfiguration("my.key", "my-value", null);
    inactiveConfiguration.setStatus(Configuration.STATUS_DELETED);
    when(configurationService.getConfigurations(isNull(), eq(true)))
        .thenReturn(Arrays.asList(inactiveConfiguration));

    List<ConfigurationDto> result = service.getConfigurations(null, true);

    assertEquals(1, result.size());
    assertEquals(Configuration.STATUS_DELETED, result.get(0).getStatus());
    verify(configurationService).getConfigurations(null, true);
  }

  @Test
  void shouldGetConfigurationById() {
    ConfigurationEntity configuration = newConfiguration("my.key", "my-value", "tenant-1");
    when(configurationService.getConfiguration("test-id")).thenReturn(configuration);

    ConfigurationDto result = service.getConfiguration(" test-id ");

    assertEquals("test-id", result.getId());
    assertEquals("my.key", result.getConfigKey());
    assertEquals("tenant-1", result.getTenantId());
    verify(configurationService).getConfiguration("test-id");
  }

  @Test
  void shouldReturnNotFoundWhenConfigurationDoesNotExist() {
    when(configurationService.getConfiguration("missing-id")).thenReturn(null);

    InvalidRequestException exception = assertThrows(
        InvalidRequestException.class,
        () -> service.getConfiguration("missing-id"));

    assertEquals(Status.NOT_FOUND, exception.getStatus());
  }

  @Test
  void shouldRejectBlankConfigurationId() {
    InvalidRequestException exception = assertThrows(
        InvalidRequestException.class,
        () -> service.getConfiguration(" "));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldUpdateConfiguration() {
    ConfigurationEntity updated = newConfiguration("my.key", "new-value", "tenant-1");
    updated.setId("new-id");
    updated.setVersion(2);
    when(configurationService.updateConfiguration("test-id", "new-value")).thenReturn(updated);

    ConfigurationDto result = service.updateConfiguration(" test-id ", updateDto("  new-value  "));

    assertEquals("new-id", result.getId());
    assertEquals("new-value", result.getConfigValue());
    assertEquals(2, result.getVersion());
    verify(configurationService).updateConfiguration("test-id", "new-value");
  }

  @Test
  void shouldRejectNullUpdateRequestBody() {
    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.updateConfiguration("test-id", null));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldMapUpdateNotValidExceptionToBadRequest() {
    when(configurationService.updateConfiguration(eq("test-id"), isNull()))
        .thenThrow(new NotValidException("configValue is mandatory"));

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.updateConfiguration("test-id", updateDto(" ")));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldMapUpdateNotFoundExceptionToNotFound() {
    when(configurationService.updateConfiguration("missing-id", "value"))
        .thenThrow(new NotFoundException("does not exist"));

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.updateConfiguration("missing-id", updateDto("value")));

    assertEquals(Status.NOT_FOUND, exception.getStatus());
  }

  @Test
  void shouldMapUpdateOfInactiveConfigurationToConflict() {
    when(configurationService.updateConfiguration("test-id", "value"))
        .thenThrow(new BadUserRequestException("status is 'INACTIVE'"));

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.updateConfiguration("test-id", updateDto("value")));

    assertEquals(Status.CONFLICT, exception.getStatus());
  }

  @Test
  void shouldMapConcurrentUpdateToConflict() {
    ProcessEnginePersistenceException persistenceException = new ProcessEnginePersistenceException(
        "An exception occurred in the persistence layer",
        new PersistenceException(new SQLException("Unique index violation: ACT_UNIQ_GE_CONFIG")));
    when(configurationService.updateConfiguration("test-id", "value")).thenThrow(persistenceException);

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.updateConfiguration("test-id", updateDto("value")));

    assertEquals(Status.CONFLICT, exception.getStatus());
  }

  private static UpdateConfigurationDto updateDto(String configValue) {
    UpdateConfigurationDto dto = new UpdateConfigurationDto();
    dto.setConfigValue(configValue);
    return dto;
  }

  @Test
  void shouldDeleteConfiguration() {
    service.deleteConfiguration(" test-id ");

    verify(configurationService).deleteConfiguration("test-id");
  }

  @Test
  void shouldRejectBlankDeleteConfigurationId() {
    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.deleteConfiguration(" "));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldMapDeleteNotFoundExceptionToNotFound() {
    doThrow(new NotFoundException("does not exist"))
        .when(configurationService).deleteConfiguration("missing-id");

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.deleteConfiguration("missing-id"));

    assertEquals(Status.NOT_FOUND, exception.getStatus());
  }

  @Test
  void shouldMapDeleteOfInactiveConfigurationToConflict() {
    doThrow(new BadUserRequestException("status is 'INACTIVE'"))
        .when(configurationService).deleteConfiguration("test-id");

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.deleteConfiguration("test-id"));

    assertEquals(Status.CONFLICT, exception.getStatus());
  }

  @Test
  void shouldThrowBadRequestForNullRequestBody() {
    InvalidRequestException exception =
        assertThrows(InvalidRequestException.class, () -> service.createConfiguration(null, uriInfo));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldMapNotValidExceptionToBadRequest() {
    when(configurationService.createConfiguration(isNull(), isNull(), isNull()))
        .thenThrow(new NotValidException("configKey is mandatory"));

    InvalidRequestException exception = assertThrows(InvalidRequestException.class,
        () -> service.createConfiguration(new CreateConfigurationDto(), uriInfo));

    assertEquals(Status.BAD_REQUEST, exception.getStatus());
  }

  @Test
  void shouldMapBadUserRequestExceptionToConflict() {
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), isNull()))
        .thenThrow(new BadUserRequestException("configuration already exists"));

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("my.key");
    dto.setConfigValue("my-value");

    InvalidRequestException exception =
        assertThrows(InvalidRequestException.class, () -> service.createConfiguration(dto, uriInfo));

    assertEquals(Status.CONFLICT, exception.getStatus());
  }

  @Test
  void shouldMapConfigurationUniqueConstraintViolationToConflict() {
    SQLException sqlException = new SQLException("Unique index or primary key violation: ACT_UNIQ_GE_CONFIG");
    ProcessEnginePersistenceException persistenceException = new ProcessEnginePersistenceException(
        "An exception occurred in the persistence layer", new PersistenceException(sqlException));
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), isNull()))
        .thenThrow(persistenceException);

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("my.key");
    dto.setConfigValue("my-value");

    InvalidRequestException exception =
        assertThrows(InvalidRequestException.class, () -> service.createConfiguration(dto, uriInfo));

    assertEquals(Status.CONFLICT, exception.getStatus());
  }

  @Test
  void shouldRethrowOtherPersistenceExceptions() {
    ProcessEnginePersistenceException persistenceException = new ProcessEnginePersistenceException(
        "An exception occurred in the persistence layer", new PersistenceException(new SQLException("connection closed")));
    when(configurationService.createConfiguration(eq("my.key"), eq("my-value"), isNull()))
        .thenThrow(persistenceException);

    CreateConfigurationDto dto = new CreateConfigurationDto();
    dto.setConfigKey("my.key");
    dto.setConfigValue("my-value");

    ProcessEnginePersistenceException exception =
        assertThrows(ProcessEnginePersistenceException.class, () -> service.createConfiguration(dto, uriInfo));

    assertEquals(persistenceException, exception);
  }

  private static class TestableConfigurationRestServiceImpl extends ConfigurationRestServiceImpl {

    private final ProcessEngine engine;

    TestableConfigurationRestServiceImpl(ProcessEngine engine, ObjectMapper objectMapper) {
      super(null, objectMapper);
      this.engine = engine;
    }

    @Override
    protected ProcessEngine getProcessEngine() {
      return engine;
    }
  }
}
