/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.engine.rest.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.sql.SQLException;
import java.util.Date;

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
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationEntity;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.ConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.CreateConfigurationDto;
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
