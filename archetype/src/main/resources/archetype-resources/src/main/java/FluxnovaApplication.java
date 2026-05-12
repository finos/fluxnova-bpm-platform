package ${package};

import org.finos.fluxnova.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the Fluxnova workflow application.
 * <p>
 * This class serves as the entry point for the application and configures
 * the Fluxnova BPM engine integration with Spring Boot.
 * </p>
 *
 * <p><strong>Key Annotations Explained:</strong></p>
 *
 * <h3>@SpringBootApplication</h3>
 * <p>
 * This is a convenience annotation that combines three Spring annotations:
 * </p>
 * <ul>
 *   <li><strong>@Configuration:</strong> Marks this class as a source of bean definitions</li>
 *   <li><strong>@EnableAutoConfiguration:</strong> Enables Spring Boot's auto-configuration mechanism</li>
 *   <li><strong>@ComponentScan:</strong> Enables component scanning in the current package and sub-packages</li>
 * </ul>
 * <p>
 * This annotation automatically configures Spring Boot based on the dependencies
 * in your classpath (e.g., web server, database connections, etc.).
 * </p>
 *
 * <h3>@EnableProcessApplication</h3>
 * <p>
 * <strong>This is a Fluxnova-specific annotation</strong> that enables the Fluxnova
 * BPM engine integration with Spring Boot.
 * </p>
 *
 * <p><strong>What it does:</strong></p>
 * <ul>
 *   <li>Initializes the Fluxnova Process Engine</li>
 *   <li>Automatically deploys BPMN, DMN, and Form files from {@code src/main/resources/processes/}</li>
 *   <li>Configures the process engine with Spring-managed beans</li>
 *   <li>Enables dependency injection of Fluxnova services (RuntimeService, TaskService, etc.)</li>
 *   <li>Sets up the Fluxnova web applications (Tasklist, Monitoring, Admin)</li>
 *   <li>Configures database persistence for process instances and history</li>
 * </ul>
 *
 * <p><strong>What gets deployed automatically:</strong></p>
 * <p>
 * When the application starts, Fluxnova scans for process definitions in:
 * </p>
 * <pre>
 * src/main/resources/
 *   ├── processes/
 *   │   ├── *.bpmn    (Business Process Models)
 *   │   ├── *.dmn     (Decision Models)
 *   │   └── *.form    (Form Definitions)
 *   └── META-INF/
 *       └── processes.xml (Deployment descriptor)
 * </pre>
 *
 * <p><strong>Available Fluxnova Services:</strong></p>
 * <p>
 * Once {@code @EnableProcessApplication} is active, you can inject these services:
 * </p>
 * <ul>
 *   <li><strong>RuntimeService:</strong> Start processes, manage process instances</li>
 *   <li><strong>TaskService:</strong> Query and complete user tasks</li>
 *   <li><strong>HistoryService:</strong> Query historical process data</li>
 *   <li><strong>RepositoryService:</strong> Manage process definitions and deployments</li>
 *   <li><strong>ManagementService:</strong> Administrative operations</li>
 *   <li><strong>IdentityService:</strong> User and group management</li>
 *   <li><strong>FilterService:</strong> Manage task filters</li>
 *   <li><strong>ExternalTaskService:</strong> Handle external tasks</li>
 * </ul>
 *
 * <p><strong>Fluxnova Web Applications:</strong></p>
 * <p>
 * The annotation also enables these web UIs (accessible after app starts):
 * </p>
 * <ul>
 *   <li><strong>Tasklist:</strong> {@code http://localhost:8080/fluxnova/app/tasklist} - Task management UI</li>
 *   <li><strong>Monitoring:</strong> {@code http://localhost:8080/fluxnova/app/monitoring} - Process monitoring</li>
 *   <li><strong>Admin:</strong> {@code http://localhost:8080/fluxnova/app/admin} - User/group administration</li>
 * </ul>
 *
 * <p><strong>Database Configuration:</strong></p>
 * <p>
 * Fluxnova requires a database to store:
 * </p>
 * <ul>
 *   <li>Process definitions (deployed BPMN/DMN models)</li>
 *   <li>Process instances (running workflows)</li>
 *   <li>Task instances (user tasks)</li>
 *   <li>Variables (process data)</li>
 *   <li>History (completed processes and tasks)</li>
 * </ul>
 * <p>
 * This demo uses H2 filesystem based database (configured in application.properties).
 * For production, use PostgreSQL, MySQL, Oracle, or SQL Server.
 * </p>
 *
 * <p><strong>Startup Sequence:</strong></p>
 * <ol>
 *   <li>Spring Boot initializes application context</li>
 *   <li>Fluxnova Process Engine is created and configured</li>
 *   <li>Database schema is created/updated automatically</li>
 *   <li>BPMN/DMN/Form files are scanned and deployed</li>
 *   <li>Default admin user is created (from application.properties)</li>
 *   <li>Web applications become available</li>
 *   <li>Application is ready to accept requests</li>
 * </ol>
 *
 * <p><strong>Production Considerations:</strong></p>
 * <ul>
 *   <li>Use a production-grade database (not H2)</li>
 *   <li>Configure proper connection pooling</li>
 *   <li>Set up authentication and authorization</li>
 *   <li>Configure history cleanup jobs</li>
 *   <li>Enable metrics and monitoring</li>
 *   <li>Set appropriate history time-to-live (TTL) values</li>
 * </ul>
 *
 * @see EnableProcessApplication
 * @see SpringBootApplication
 * @see org.finos.fluxnova.bpm.engine.RuntimeService
 * @see org.finos.fluxnova.bpm.engine.TaskService
 */
@SpringBootApplication
@EnableProcessApplication
public class FluxnovaApplication {

    public static void main(String[] args) {
        SpringApplication.run( FluxnovaApplication.class, args);
    }
}
