package ${package}.filter;

import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.FilterService;
import org.finos.fluxnova.bpm.engine.filter.Filter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Service responsible for creating default filters on application startup.
 * <p>
 * This component runs automatically when the application starts and creates
 * predefined filters for local development and testing purposes. It is only
 * active when the application is running with 'local' or 'default' (no profile)
 * Spring profiles.
 * </p>
 * <p>
 * The default filters created include:
 * <ul>
 *   <li>My Tasks - A filter for the admin user with priority -10</li>
 * </ul>
 * </p>
 * <p>
 * <strong>Note:</strong> This service is disabled in production environments
 * to prevent automatic creation of development-specific data.
 * </p>
 *
 * @see ApplicationRunner
 * @see FilterService
 * @see Filter
 */
@Slf4j
@Component
public class DefaultFilterService implements ApplicationRunner {

    /**
     * Service for managing BPM filters.
     */
    private final FilterService filterService;

    /**
     * Constructs a new DefaultFilterService with the required dependencies.
     *
     * @param filterService the service used to create and save filters
     */
    public DefaultFilterService(FilterService filterService) {
        this.filterService = filterService;
    }

    /**
     * Executes on application startup to create default filters.
     * <p>
     * This method is automatically invoked by Spring Boot after all beans
     * have been initialized. It creates a default "My Tasks" filter for
     * the admin user with a priority of -10.
     * </p>
     *
     * @param args application arguments passed during startup (not used)
     * @throws Exception if filter creation fails
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Creating Default Filters for local profile");

        Filter myTasksFilter = filterService.createFilterQuery()
                .filterName("My Tasks")
                .singleResult();
        if (myTasksFilter == null) {
            Map<String, Object> filterProperties = new HashMap<>();
            filterProperties.put("description", "Default Filter for Admin user - for local profile usage only");
            filterProperties.put("priority", -10);

            myTasksFilter = filterService.newTaskFilter()
                    .setName("My Tasks")
                    .setProperties(filterProperties)
                    .setOwner("admin");
            filterService.saveFilter(myTasksFilter);
        }

        log.info("Created Default Filters");
    }
}
