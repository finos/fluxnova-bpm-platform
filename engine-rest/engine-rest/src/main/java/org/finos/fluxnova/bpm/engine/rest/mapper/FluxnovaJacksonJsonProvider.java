package org.finos.fluxnova.bpm.engine.rest.mapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;

import org.finos.fluxnova.bpm.engine.rest.hal.Hal;

import tools.jackson.jakarta.rs.json.JacksonJsonProvider;

/**
 * Custom JAX-RS JSON provider that configures Jackson's ObjectMapper using
 * {@link JacksonConfigurator#configureObjectMapper()} so that dates are serialized
 * in the JVM's local timezone (e.g. {@code 2016-04-12T15:29:33.000-0600}) instead
 * of UTC ({@code 2016-04-12T21:29:33.000Z}).
 *
 * <p>The standard {@link JacksonJsonProvider} registered via class reference does not
 * pick up the {@code ContextResolver<ObjectMapper>} provided by {@link JacksonConfigurator}
 * in Jackson 3.x. Passing the configured mapper directly via the constructor is the
 * reliable alternative.</p>
 */
@Provider
@Consumes({MediaType.APPLICATION_JSON, Hal.APPLICATION_HAL_JSON, "text/json"})
@Produces({MediaType.APPLICATION_JSON, Hal.APPLICATION_HAL_JSON, "text/json"})
public class FluxnovaJacksonJsonProvider extends JacksonJsonProvider {

    public FluxnovaJacksonJsonProvider() {
        super(JacksonConfigurator.configureObjectMapper());
    }

}
