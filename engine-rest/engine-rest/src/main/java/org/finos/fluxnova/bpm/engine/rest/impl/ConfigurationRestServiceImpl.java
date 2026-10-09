package org.finos.fluxnova.bpm.engine.rest.impl;

import tools.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.util.ExceptionUtil;
import org.finos.fluxnova.bpm.engine.rest.ConfigurationRestService;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.ConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.CreateConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.UpdateConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;

public class ConfigurationRestServiceImpl extends AbstractRestProcessEngineAware implements ConfigurationRestService {

  public ConfigurationRestServiceImpl(String engineName, final ObjectMapper objectMapper) {
    super(engineName, objectMapper);
  }

  @Override
  public Response createConfiguration(CreateConfigurationDto configurationDto, UriInfo uriInfo) {
    if (configurationDto == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Request body must not be null");
    }

    ProcessEngine engine = getProcessEngine();
    ConfigurationService configurationService = engine.getConfigurationService();

    Configuration newConfiguration;
    try {
      newConfiguration = configurationService.createConfiguration(
          trimToNull(configurationDto.getConfigKey()),
          trimToNull(configurationDto.getConfigValue()),
          trimToNull(configurationDto.getTenantId()));

    } catch (NotValidException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e, "Could not save configuration: " + e.getMessage());

    } catch (BadUserRequestException e) {
      throw new InvalidRequestException(Status.CONFLICT, e, "Could not save configuration: " + e.getMessage());

    } catch (ProcessEngineException e) {
      if (isConfigurationUniqueConstraintViolation(e)) {
        throw new InvalidRequestException(Status.CONFLICT, e,
            "Could not save configuration: An active configuration with key '"
                + trimToNull(configurationDto.getConfigKey()) + "' already exists for "
                + getScopeDescription(trimToNull(configurationDto.getTenantId())));
      }
      throw e;
    }

    URI location = uriInfo.getBaseUriBuilder()
        .path(relativeRootResourcePath)
        .path(ConfigurationRestService.PATH)
        .path(newConfiguration.getId())
        .build();

    return Response.created(location).entity(ConfigurationDto.fromConfiguration(newConfiguration)).build();
  }

  @Override
  public List<ConfigurationDto> getConfigurations(String tenantId, Boolean includeInactive) {
    List<ConfigurationDto> configurations = new ArrayList<ConfigurationDto>();
    for (Configuration configuration : getProcessEngine().getConfigurationService()
        .getConfigurations(trimToNull(tenantId), Boolean.TRUE.equals(includeInactive))) {
      configurations.add(ConfigurationDto.fromConfiguration(configuration));
    }
    return configurations;
  }

  @Override
  public ConfigurationDto getConfiguration(String configurationId) {
    String normalizedConfigurationId = trimToNull(configurationId);
    if (normalizedConfigurationId == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Configuration id must not be blank");
    }

    Configuration configuration = getProcessEngine().getConfigurationService()
        .getConfiguration(normalizedConfigurationId);
    if (configuration == null) {
      throw new InvalidRequestException(
          Status.NOT_FOUND,
          "Configuration with id '" + normalizedConfigurationId + "' does not exist");
    }

    return ConfigurationDto.fromConfiguration(configuration);
  }

  @Override
  public ConfigurationDto updateConfiguration(String configurationId, UpdateConfigurationDto configurationDto) {
    if (configurationDto == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Request body must not be null");
    }

    String normalizedConfigurationId = trimToNull(configurationId);
    if (normalizedConfigurationId == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Configuration id must not be blank");
    }

    Configuration updatedConfiguration;
    try {
      updatedConfiguration = getProcessEngine().getConfigurationService()
          .updateConfiguration(normalizedConfigurationId, trimToNull(configurationDto.getConfigValue()));

    } catch (NotValidException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e, "Could not update configuration: " + e.getMessage());

    } catch (NotFoundException e) {
      throw new InvalidRequestException(Status.NOT_FOUND, e, "Could not update configuration: " + e.getMessage());

    } catch (BadUserRequestException e) {
      throw new InvalidRequestException(Status.CONFLICT, e, "Could not update configuration: " + e.getMessage());

    } catch (ProcessEngineException e) {
      if (isConfigurationUniqueConstraintViolation(e)) {
        throw new InvalidRequestException(Status.CONFLICT, e,
            "Could not update configuration: the configuration was modified concurrently");
      }
      throw e;
    }

    return ConfigurationDto.fromConfiguration(updatedConfiguration);
  }

  @Override
  public void deleteConfiguration(String configurationId) {
    String normalizedConfigurationId = trimToNull(configurationId);
    if (normalizedConfigurationId == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Configuration id must not be blank");
    }

    try {
      getProcessEngine().getConfigurationService().deleteConfiguration(normalizedConfigurationId);

    } catch (NotValidException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e, "Could not delete configuration: " + e.getMessage());

    } catch (NotFoundException e) {
      throw new InvalidRequestException(Status.NOT_FOUND, e, "Could not delete configuration: " + e.getMessage());

    } catch (BadUserRequestException e) {
      throw new InvalidRequestException(Status.CONFLICT, e, "Could not delete configuration: " + e.getMessage());
    }
  }

  protected static String trimToNull(String value) {
    if (value == null) {
      return null;
    }
    String trimmed = value.trim();
    return trimmed.isEmpty() ? null : trimmed;
  }

  protected static boolean isConfigurationUniqueConstraintViolation(ProcessEngineException exception) {
    return ExceptionUtil.checkConstraintViolationException(exception)
        && containsMessage(exception, "ACT_UNIQ_GE_CONFIG");
  }

  protected static boolean containsMessage(Throwable throwable, String value) {
    while (throwable != null) {
      String message = throwable.getMessage();
      if (message != null && message.toUpperCase().contains(value)) {
        return true;
      }
      throwable = throwable.getCause();
    }
    return false;
  }

  protected static String getScopeDescription(String tenantId) {
    return tenantId == null ? "the global scope" : "tenant '" + tenantId + "'";
  }

}
