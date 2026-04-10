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
 * Attributes displayName, group and groupDisplayName are only included in
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
    when(defaultEngine.getDisplayName()).thenReturn(null);
    when(defaultEngine.getGroup()).thenReturn(null);
    when(defaultEngine.getGroupDisplayName()).thenReturn(null);

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDisplayName()).thenReturn(null);
    when(anotherEngine.getGroup()).thenReturn(null);
    when(anotherEngine.getGroupDisplayName()).thenReturn(null);

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('displayName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('group')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDisplayName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('displayName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('group')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDisplayName')", equalTo(false));
  }

  @Test
  public void shouldReturnAttributesWhenSetOnEngine() {
    ProcessEngine defaultEngine = getProcessEngine(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME);
    when(defaultEngine.getDisplayName()).thenReturn("defaultDisplayName");
    when(defaultEngine.getGroup()).thenReturn("defaultGroupName");
    when(defaultEngine.getGroupDisplayName()).thenReturn("defaultGroupDisplayName");

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDisplayName()).thenReturn("anotherDisplayName");
    when(anotherEngine.getGroup()).thenReturn("anotherGroupName");
    when(anotherEngine.getGroupDisplayName()).thenReturn("anotherGroupDisplayName");

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.displayName", equalTo("defaultDisplayName"))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.group", equalTo("defaultGroupName"))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDisplayName", equalTo("defaultGroupDisplayName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.displayName", equalTo("anotherDisplayName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.group", equalTo("anotherGroupName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDisplayName", equalTo("anotherGroupDisplayName"));
  }

  @Test
  public void shouldOnlyReturnSetAttributesWhenSomeAreNull() {
    ProcessEngine defaultEngine = getProcessEngine(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME);
    when(defaultEngine.getDisplayName()).thenReturn(null);
    when(defaultEngine.getGroup()).thenReturn(null);
    when(defaultEngine.getGroupDisplayName()).thenReturn(null);

    ProcessEngine anotherEngine = getProcessEngine(MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME);
    when(anotherEngine.getDisplayName()).thenReturn("anotherDisplayName");
    when(anotherEngine.getGroup()).thenReturn("anotherGroupName");
    when(anotherEngine.getGroupDisplayName()).thenReturn("anotherGroupDisplayName");

    given()
      .accept(ContentType.JSON)
    .when()
      .get(ENGINES_URL)
    .then()
      .statusCode(Status.OK.getStatusCode())
      .body("", hasSize(2))
      .body("name", hasItems(MockProvider.EXAMPLE_PROCESS_ENGINE_NAME, MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('displayName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('group')", equalTo(false))
      .body("find { it.name == '" + MockProvider.EXAMPLE_PROCESS_ENGINE_NAME + "' }.containsKey('groupDisplayName')", equalTo(false))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.displayName", equalTo("anotherDisplayName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.group", equalTo("anotherGroupName"))
      .body("find { it.name == '" + MockProvider.ANOTHER_EXAMPLE_PROCESS_ENGINE_NAME + "' }.groupDisplayName", equalTo("anotherGroupDisplayName"));
  }
}
