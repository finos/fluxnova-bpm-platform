package org.finos.fluxnova.bpm.engine.rest;

import java.util.List;

import org.finos.fluxnova.bpm.engine.rest.dto.configuration.ConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.CreateConfigurationDto;
import org.finos.fluxnova.bpm.engine.rest.dto.configuration.UpdateConfigurationDto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Produces(MediaType.APPLICATION_JSON)
public interface ConfigurationRestService {

  public static final String PATH = "/configurations";

  /**
   * Creates a new configuration entry.
   *
   * <p>If {@code tenantId} is omitted or blank the entry is treated as a global
   * configuration applicable to all tenants. A duplicate {@code (configKey, tenantId)}
   * combination with {@code STATUS_=ACTIVE} results in a {@code 409 Conflict}.</p>
   *
   * @param configurationDto the create request containing {@code configKey},
   *                         {@code configValue} and an optional {@code tenantId}
   * @param uriInfo          JAX-RS URI context used to build the {@code Location} header
   * @return {@code 201 Created} with the persisted configuration and a {@code Location}
   *         header pointing to the new resource
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response createConfiguration(CreateConfigurationDto configurationDto, @Context UriInfo uriInfo);

  /**
   * Returns the configurations applicable to a tenant. If {@code tenantId} is
   * omitted or blank, the global default configurations are returned. For a
   * tenant, active global configurations are returned with the tenant's active
   * entries overriding global entries of the same key. With
   * {@code includeInactive=true}, all global and tenant entries of every status
   * are returned without merging.
   *
   * @param tenantId optional tenant scope
   * @param includeInactive whether to include inactive configurations
   * @return configurations applicable to the requested scope
   */
  @GET
  List<ConfigurationDto> getConfigurations(@QueryParam("tenantId") String tenantId,
                                           @QueryParam("includeInactive") Boolean includeInactive);

  /**
   * Returns a configuration by id.
   *
   * @param configurationId the configuration id
   * @return the configuration
   */
  @GET
  @Path("/{configurationId}")
  ConfigurationDto getConfiguration(@PathParam("configurationId") String configurationId);

  /**
   * Updates an active configuration by creating a new version.
   *
   * <p>The existing entry is marked {@code INACTIVE} and a new {@code ACTIVE} entry
   * with the same key and tenant scope and an incremented version is created.</p>
   *
   * @param configurationId the id of the active configuration to update
   * @param configurationDto the update request containing the new {@code configValue}
   * @return the newly created active configuration version
   */
  @PUT
  @Path("/{configurationId}")
  @Consumes(MediaType.APPLICATION_JSON)
  ConfigurationDto updateConfiguration(@PathParam("configurationId") String configurationId,
                                       UpdateConfigurationDto configurationDto);

  /**
   * Soft-deletes an active configuration by marking it {@code INACTIVE}.
   *
   * @param configurationId the id of the active configuration to delete
   */
  @DELETE
  @Path("/{configurationId}")
  void deleteConfiguration(@PathParam("configurationId") String configurationId);

}
