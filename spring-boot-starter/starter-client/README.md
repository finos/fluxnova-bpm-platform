# Flowave External Task Client as Spring Boot Starter

This project provides a Spring Boot Starter that allows you to implement an External Task Worker for Flowave. It uses the Flowave REST API to fetch, lock, and complete External Service Tasks. It is based on the [Java External Task Client](../../clients/java).
** Needs To Be Reviewed **
* [Documentation](https://docs.camunda.org/manual/develop/user-guide/ext-client/spring-boot-starter/)
* [Examples](https://github.com/camunda/camunda-bpm-examples/tree/master/spring-boot-starter/external-task-client)

## Dependency

You need this dependency to get started:

```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm.springboot</groupId>
  <artifactId>flowave-bpm-spring-boot-starter-external-task-client</artifactId>
  <version>...</version>
</dependency>
```

## Configuration

You can configure the Flowave Platform Runtime REST API endpoint and other properties in the `application.yml` file:

```yaml
flowave.bpm.client:
  base-url: http://localhost:8080/engine-rest
  subscriptions:
    creditScoreChecker:
        process-definition-key: loan_process
        include-extension-properties: true
        variable-names: defaultScore
```

## Topic Subscription

```java
@Configuration
@ExternalTaskSubscription("creditScoreChecker")
public class CreditScoreCheckerHandler implements ExternalTaskHandler {

  @Override
  public void execute(ExternalTask externalTask, 
                      ExternalTaskService externalTaskService) {
    // add your business logic here
  }

}
```

## Use Spring (not Spring Boot)

You can also use the basic Spring integration without the Spring Boot Starter:

```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm</groupId>
  <artifactId>flowave-external-task-client-spring</artifactId>
  <version>...</version>
</dependency>
```

### Configuration

To enable the External Task Subscriptions and bootstrap the Client, add the `EnableExternalTaskClient` annotation and configure the REST API endpoint and other configuration options.

```java
@Configuration
@EnableExternalTaskClient(baseUrl = "http://localhost:8080/engine-rest")
public class SimpleConfiguration {
}
```

## Credits

The Flowave External Task Client Spring Boot Starter project used to be a community extension initially created by [Oliver Steinhauer](https://github.com/osteinhauer).
