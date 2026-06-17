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
package org.finos.fluxnova.bpm.engine.rest;

import static io.restassured.RestAssured.given;
import static org.finos.fluxnova.bpm.engine.rest.helper.MockProvider.EXAMPLE_USER_OPERATION_ANNOTATION;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.restassured.http.ContentType;
import org.finos.fluxnova.bpm.engine.AuthorizationException;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.RuntimeServiceImpl;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.helper.MockProvider;
import org.finos.fluxnova.bpm.engine.rest.util.container.TestContainerRule;
import org.finos.fluxnova.bpm.engine.runtime.Incident;
import org.finos.fluxnova.bpm.engine.runtime.IncidentQuery;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;


public class IncidentRestServiceInteractionTest extends AbstractRestServiceTest {

  @ClassRule
  public static TestContainerRule rule = new TestContainerRule();

  protected static final String INCIDENT_URL = TEST_RESOURCE_ROOT_PATH + "/incident";
  protected static final String SINGLE_INCIDENT_URL = INCIDENT_URL + "/{id}";
  protected static final String INCIDENT_ANNOTATION_URL = SINGLE_INCIDENT_URL + "/annotation";
  protected static final String PROCESS_INSTANCE_INCIDENT_COUNT_URL = INCIDENT_URL + "/process-instance-statistics";

  private RuntimeServiceImpl mockRuntimeService;
  private IncidentQuery mockedQuery;

  @Before
  public void setUpRuntimeData() {
    List<Incident> incidents = MockProvider.createMockIncidents();

    mockedQuery = setupMockIncidentQuery(incidents);
  }

  private IncidentQuery setupMockIncidentQuery(List<Incident> incidents) {
    IncidentQuery sampleQuery = mock(IncidentQuery.class);

    when(sampleQuery.incidentId(anyString())).thenReturn(sampleQuery);
    when(sampleQuery.singleResult()).thenReturn(mock(Incident.class));

    mockRuntimeService = mock(RuntimeServiceImpl.class);
    when(processEngine.getRuntimeService()).thenReturn(mockRuntimeService);
    when(mockRuntimeService.createIncidentQuery()).thenReturn(sampleQuery);

    return sampleQuery;
  }

  @Test
  public void testGetIncident() {

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.OK.getStatusCode())
    .when()
      .get(SINGLE_INCIDENT_URL);

    verify(mockRuntimeService).createIncidentQuery();
    verify(mockedQuery).incidentId(EXAMPLE_INCIDENT_ID);
    verify(mockedQuery).singleResult();
  }

  @Test
  public void testGetUnexistingIncident() {
    when(mockedQuery.singleResult()).thenReturn(null);

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.NOT_FOUND.getStatusCode())
    .when()
      .get(SINGLE_INCIDENT_URL);

    verify(mockRuntimeService).createIncidentQuery();
    verify(mockedQuery).incidentId(EXAMPLE_INCIDENT_ID);
    verify(mockedQuery).singleResult();
  }

  @Test
  public void testResolveIncident() {

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.NO_CONTENT.getStatusCode())
    .when()
      .delete(SINGLE_INCIDENT_URL);

    verify(mockRuntimeService).resolveIncident(EXAMPLE_INCIDENT_ID);
  }

  @Test
  public void testResolveUnexistingIncident() {
    doThrow(new NotFoundException()).when(mockRuntimeService).resolveIncident(anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.NOT_FOUND.getStatusCode())
    .when()
      .delete(SINGLE_INCIDENT_URL);

    verify(mockRuntimeService).resolveIncident(EXAMPLE_INCIDENT_ID);
  }

  @Test
  public void shouldSetAnnotation() {
    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
      .contentType(MediaType.APPLICATION_JSON)
      .body("{ \"annotation\": \"" + EXAMPLE_USER_OPERATION_ANNOTATION + "\" }")
    .then().expect()
      .statusCode(Status.NO_CONTENT.getStatusCode())
    .when()
      .put(INCIDENT_ANNOTATION_URL);

    verify(mockRuntimeService)
      .setAnnotationForIncidentById(EXAMPLE_INCIDENT_ID, EXAMPLE_USER_OPERATION_ANNOTATION);
  }

  @Test
  public void shouldThrowNotValidExceptionWhenSetAnnotation() {
    doThrow(new NotValidException("expected"))
      .when(mockRuntimeService)
      .setAnnotationForIncidentById(anyString(), anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
      .contentType(MediaType.APPLICATION_JSON)
      .body("{ \"annotation\": \"" + EXAMPLE_USER_OPERATION_ANNOTATION + "\" }")
    .then().expect()
      .statusCode(Status.BAD_REQUEST.getStatusCode())
    .when()
      .put(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void shouldThrowAuthorizationExceptionWhenSetAnnotation() {
    doThrow(new AuthorizationException("expected"))
      .when(mockRuntimeService)
      .setAnnotationForIncidentById(anyString(), anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
      .contentType(MediaType.APPLICATION_JSON)
      .body("{ \"annotation\": \"" + EXAMPLE_USER_OPERATION_ANNOTATION + "\" }")
    .then().expect()
      .statusCode(Status.FORBIDDEN.getStatusCode())
    .when()
      .put(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void shouldThrowBadRequestExceptionWhenSetAnnotation() {
    doThrow(new BadUserRequestException("expected"))
      .when(mockRuntimeService)
      .setAnnotationForIncidentById(anyString(), anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
      .contentType(MediaType.APPLICATION_JSON)
      .body("{ \"annotation\": \"" + EXAMPLE_USER_OPERATION_ANNOTATION + "\" }")
    .then().expect()
      .statusCode(Status.BAD_REQUEST.getStatusCode())
    .when()
      .put(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void shouldClearAnnotation() {
    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.NO_CONTENT.getStatusCode())
    .when()
      .delete(INCIDENT_ANNOTATION_URL);

    verify(mockRuntimeService).clearAnnotationForIncidentById(EXAMPLE_INCIDENT_ID);
  }

  @Test
  public void shouldThrowNotValidExceptionWhenClearAnnotation() {
    doThrow(new NotValidException("expected"))
      .when(mockRuntimeService)
      .clearAnnotationForIncidentById(anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.BAD_REQUEST.getStatusCode())
    .when()
      .delete(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void shouldThrowAuthorizationExceptionWhenClearAnnotation() {
    doThrow(new AuthorizationException("expected"))
      .when(mockRuntimeService)
      .clearAnnotationForIncidentById(anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .then().expect()
      .statusCode(Status.FORBIDDEN.getStatusCode())
    .when()
      .delete(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void shouldThrowBadRequestExceptionWhenClearAnnotation() {
    doThrow(new BadUserRequestException("expected"))
      .when(mockRuntimeService)
      .clearAnnotationForIncidentById(anyString());

    given()
      .pathParam("id", EXAMPLE_INCIDENT_ID)
    .expect()
      .statusCode(Status.BAD_REQUEST.getStatusCode())
    .when()
      .delete(INCIDENT_ANNOTATION_URL);
  }

  @Test
  public void testGetProcessInstanceIncidentCount() {
    Incident mockIncident = MockProvider.createMockIncident();
    IncidentQuery sampleIncidentQuery = mock(IncidentQuery.class);
    when(mockRuntimeService.createIncidentQuery()).thenReturn(sampleIncidentQuery);
    when(sampleIncidentQuery.processInstanceId(MockProvider.EXAMPLE_PROCESS_INSTANCE_ID)).thenReturn(
            sampleIncidentQuery);
    when(sampleIncidentQuery.singleResult()).thenReturn(mockIncident);
    Map<String, Object> messageBodyJson = new HashMap<>();
    messageBodyJson.put("processInstanceIds",
            List.of(MockProvider.EXAMPLE_PROCESS_INSTANCE_ID, MockProvider.ANOTHER_EXAMPLE_PROCESS_INSTANCE_ID));
    given().contentType(ContentType.JSON)
            .body(messageBodyJson)
            .then()
            .expect()
            .body("$.size()", equalTo(2))
            .body("processInstanceId",
                    hasItems(MockProvider.EXAMPLE_PROCESS_INSTANCE_ID, MockProvider.ANOTHER_EXAMPLE_PROCESS_INSTANCE_ID))
            .body("incidentCount", hasItems(0, 0))
            .statusCode(Status.OK.getStatusCode())
            .when()
            .post(PROCESS_INSTANCE_INCIDENT_COUNT_URL);
  }

  @Test
  public void testGetProcessInstanceIncidentCountThrowsError() {
    Map<String, Object> messageBodyJson = new HashMap<>();
    int greaterThanMaxAllowedProcessInstanceCount = MockProvider.MAX_PI_ALLOWED_FOR_RETRIEVING_INCIDENT_COUNT + 1;
    List<String> badListWithProcessInstanceMoreThanLimit = new ArrayList<>(
            Collections.nCopies(greaterThanMaxAllowedProcessInstanceCount, MockProvider.EXAMPLE_PROCESS_INSTANCE_ID));
    messageBodyJson.put("processInstanceIds", badListWithProcessInstanceMoreThanLimit);
    given().contentType(ContentType.JSON)
            .body(messageBodyJson)
            .then()
            .expect()
            .contentType(ContentType.JSON)
            .statusCode(Status.BAD_REQUEST.getStatusCode())
            .body("type", Matchers.equalTo(InvalidRequestException.class.getSimpleName()))
            .body("message", Matchers.equalTo(
                    "Input request exceeds the limit of " + MockProvider.MAX_PI_ALLOWED_FOR_RETRIEVING_INCIDENT_COUNT + "."))
            .when()
            .post(PROCESS_INSTANCE_INCIDENT_COUNT_URL);


  }

  @Test
  public void testGetProcessInstanceIncidentCountWithEmptyInputProvidesEmptyOutputAsResponse() {
    Map<String, Object> messageBodyJson = new HashMap<>();
    List<String> emptyList = new ArrayList<>();
    messageBodyJson.put("processInstanceIds", emptyList);
    given().contentType(ContentType.JSON)
            .body(messageBodyJson)
            .then()
            .expect()
            .contentType(ContentType.JSON)
            .statusCode(Status.OK.getStatusCode())
            .body("$.size()", equalTo(0))
            .when()
            .post(PROCESS_INSTANCE_INCIDENT_COUNT_URL);

  }
}
