# Integration Test Fixes for External Task Client

## Summary of Issues Found

1. **Cargo Container Timing Issue**: The Cargo Maven plugin was starting the Tomcat container in the background, but Maven was immediately proceeding to run integration tests before the server was fully ready.

2. **Missing Synchronization**: The original configuration had no mechanism to wait for the server to be responsive before running tests, causing tests to timeout or get 404 errors.

3. **Warning About 'wait' Parameter**: The original pom.xml had `<wait>false</wait>` which caused warnings and didn't properly synchronize container startup with test execution.

## Fixes Applied

### 1. Added AntRun Plugin for Server Readiness Check

Added a `maven-antrun-plugin` execution that explicitly waits for the Tomcat server to respond before running integration tests:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-antrun-plugin</artifactId>
  <version>3.1.0</version>
  <executions>
    <execution>
      <id>wait-for-server</id>
      <phase>pre-integration-test</phase>
      <goals>
        <goal>run</goal>
      </goals>
      <configuration>
        <skip>${skipTests}</skip>
        <target>
          <echo message="Waiting for Tomcat server to be ready..."/>
          <waitfor maxwait="2" maxwaitunit="minute" checkevery="2" checkeveryunit="second" timeoutproperty="server.timeout">
            <http url="http://localhost:${tomcat.connector.http.port}/engine-rest/engine/default/process-definition"/>
          </waitfor>
          <fail message="Server did not start in time" if="server.timeout"/>
          <echo message="Server is ready!"/>
        </target>
      </configuration>
    </execution>
  </executions>
</plugin>
```

**How it works:**
- Runs in the `pre-integration-test` phase (after Cargo starts but before tests run)
- Polls the REST API endpoint every 2 seconds
- Waits up to 2 minutes for a successful HTTP response
- Fails the build if the server doesn't respond in time
- Only proceeds to run tests once the server is confirmed ready

### 2. Enhanced Cargo Configuration

- Added `<cargo.hostname>localhost</cargo.hostname>` property for proper configuration
- Added `pingURL` and `pingTimeout` to the engine-rest deployable
- Removed the problematic `<wait>false</wait>` parameter that was causing warnings

### 3. Cargo Plugin Configuration

```xml
<deployables>
  <deployable>
    <groupId>org.finos.fluxnova.bpm</groupId>
    <artifactId>fluxnova-engine-rest-jakarta</artifactId>
    <type>war</type>
    <classifier>tomcat</classifier>
    <properties>
      <context>engine-rest</context>
    </properties>
    <pingURL>http://localhost:${tomcat.connector.http.port}/engine-rest/engine/default/process-definition</pingURL>
    <pingTimeout>${cargo.deploy.timeout}</pingTimeout>
  </deployable>
  <deployable>
    <groupId>org.finos.fluxnova.bpm.qa</groupId>
    <artifactId>engine-variable-test</artifactId>
    <type>war</type>
  </deployable>
</deployables>
```

## Known Issues Remaining

### Engine Runtime Error

During testing, I observed this error in the Tomcat logs:

```
ENGINE-REST-HTTP500 org.finos.fluxnova.bpm.engine.ProcessEngineException: Object values cannot be used to query
```

This error occurs in `SingleQueryVariableValueCondition.determineSerializer()` when tests try to fetch external tasks with certain query conditions. This is a **separate issue in the engine code itself**, not related to the Cargo container startup.

**Location**: The error originates from:
- `org.finos.fluxnova.bpm.engine.impl.SingleQueryVariableValueCondition.determineSerializer()`
- Called during external task fetch operations

This needs to be investigated separately as it may indicate an issue with how query variables are being validated or serialized in the JUnit 5 / Spring Boot 4 migration.

## Testing Instructions

1. **Run the integration tests:**
   ```bash
   cd /Users/a685483/Downloads/repos/finos-fluxnova-bpm-platform
   mvn clean install -rf :fluxnova-external-task-client
   ```

2. **Expected Behavior:**
   - Maven will start the Cargo plugin
   - Tomcat will start in the background
   - The AntRun plugin will wait and display "Waiting for Tomcat server to be ready..."
   - Once the server responds, it will display "Server is ready!"
   - Then the integration tests will run

3. **Monitor Progress:**
   - Watch for the "Waiting for Tomcat server to be ready..." message
   - Check Tomcat logs at: `clients/java/client/target/fluxnova-tomcat/server/apache-tomcat-10.1.43/logs/catalina.out`

## Next Steps

If tests still fail after these fixes:

1. **Investigate the "Object values cannot be used to query" error** - This appears to be a regression in the engine code that needs separate investigation

2. **Check test configurations** - Some tests may need updates for JUnit 5 / Spring Boot 4 compatibility

3. **Review query variable handling** - The error suggests issues with how object-typed variables are handled in external task queries

## Files Modified

- `/Users/a685483/Downloads/repos/finos-fluxnova-bpm-platform/clients/java/client/pom.xml`
  - Added maven-antrun-plugin execution for server readiness check
  - Enhanced Cargo configuration
  - Removed problematic wait parameter
  - Added hostname and ping configuration

## Additional Notes

The Tomcat server **IS starting successfully** - the logs confirm it's running on port 50080 and the REST API is deployed. The primary fix was adding proper synchronization to ensure tests don't start before the server is ready to accept requests.

