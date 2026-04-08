package org.finos.fluxnova.bpm.engine.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response.Status;

import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.rest.helper.MockProvider;
import org.finos.fluxnova.bpm.engine.rest.util.container.TestContainerRule;
import org.junit.ClassRule;
import org.junit.Test;

import io.restassured.http.ContentType;

/**
 * Tests for the /engine endpoint that retrieves list of process engines.
 * Attributes description, groupName and groupDescription are only included in
 * the response when the engine returns a non-null value for them. The name
 * attribute is always present.
 */
public class EnginesRestTest extends AbstractRestServiceTest {

  @ClassRule
  public static TestContainerRule rule = new TestContainerRule();

  protected static final String ENGINES_URL = TEST_RESOURCE_ROOT_PATH + "/engine";

  @Test
  public void shouldAlwaysReturnNameAndOmitUnsetAttributes() {
    ProcessEngine defaultEngine = getProcessEngine(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME);
    when(defaultEngine.getDescription()).thenReturn(null);
    when(defaultEngine.getGroupName()).thenReturn(null);
    when(defaultEngine.getGroupDescription()).thenReturn(null);

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDescription()).thenReturn(null);
    when(anotherEngine.getGroupName()).thenReturn(null);
    when(anotherEngine.getGroupDescription()).thenReturn(null);

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('description')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDescription')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('description')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDescription')", equalTo(false));
  }

  @Test
  public void shouldReturnAttributesWhenSetOnEngine() {
    ProcessEngine defaultEngine = getProcessEngine(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME);
    when(defaultEngine.getDescription()).thenReturn("defaultDescription");
    when(defaultEngine.getGroupName()).thenReturn("defaultGroupName");
    when(defaultEngine.getGroupDescription()).thenReturn("defaultGroupDescription");

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDescription()).thenReturn("anotherDescription");
    when(anotherEngine.getGroupName()).thenReturn("anotherGroupName");
    when(anotherEngine.getGroupDescription()).thenReturn("anotherGroupDescription");

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.description", equalTo("defaultDescription"))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupName", equalTo("defaultGroupName"))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDescription", equalTo("defaultGroupDescription"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.description", equalTo("anotherDescription"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupName", equalTo("anotherGroupName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDescription", equalTo("anotherGroupDescription"));
  }

  @Test
  public void shouldOnlyReturnSetAttributesWhenSomeAreNull() {
    ProcessEngine defaultEngine = getProcessEngine(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME);
    when(defaultEngine.getDescription()).thenReturn(null);
    when(defaultEngine.getGroupName()).thenReturn(null);
    when(defaultEngine.getGroupDescription()).thenReturn(null);

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDescription()).thenReturn("anotherDescription");
    when(anotherEngine.getGroupName()).thenReturn("anotherGroupName");
    when(anotherEngine.getGroupDescription()).thenReturn("anotherGroupDescription");

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('description')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDescription')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.description", equalTo("anotherDescription"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupName", equalTo("anotherGroupName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDescription", equalTo("anotherGroupDescription"));
  }
}
