package org.finos.fluxnova.bpm.engine.test.api.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.task.Attachment;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.RequiredHistoryLevel;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test to verify createdBy field behavior on attachments
 */
@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_AUDIT)
public class AttachmentCreatedByTest {

  @Rule
  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();

  private String taskId;

  @Before
  public void setUp() {
    Task task = engineRule.getTaskService().newTask();
    engineRule.getTaskService().saveTask(task);
    taskId = task.getId();
  }

  @After
  public void tearDown() {
    if (taskId != null) {
      engineRule.getTaskService().deleteTask(taskId, true);
    }
  }

  @Test
  public void testAttachmentCreatedByWithAuthenticatedUser() {
    // given
    engineRule.getIdentityService().setAuthenticatedUserId("testUser");

    // when
    Attachment attachment = engineRule.getTaskService().createAttachment(
        "web page", taskId, null, "testAttachment", "test description", "http://example.com");

    // then
    assertNotNull(attachment);
    assertEquals("testUser", attachment.getCreatedBy());

    // verify it persists
    Attachment fetched = engineRule.getTaskService().getAttachment(attachment.getId());
    assertEquals("testUser", fetched.getCreatedBy());

    // cleanup
    engineRule.getIdentityService().clearAuthentication();
  }

  @Test
  public void testAttachmentCreatedByWithoutAuthenticatedUser() {
    // given - no authenticated user set
    engineRule.getIdentityService().clearAuthentication();

    // when
    Attachment attachment = engineRule.getTaskService().createAttachment(
        "web page", taskId, null, "testAttachment", "test description", "http://example.com");

    // then - should handle null gracefully (simulates legacy data)
    assertNotNull(attachment);
    assertNull("createdBy should be null when no user is authenticated", attachment.getCreatedBy());

    // verify it persists and retrieves without NPE
    Attachment fetched = engineRule.getTaskService().getAttachment(attachment.getId());
    assertNotNull("Attachment should be retrievable even with null createdBy", fetched);
    assertNull("createdBy should remain null", fetched.getCreatedBy());
  }

  @Test
  public void testAttachmentListWithNullCreatedBy() {
    // given - create multiple attachments, some with user, some without
    engineRule.getIdentityService().setAuthenticatedUserId("user1");
    engineRule.getTaskService().createAttachment(
        "web page", taskId, null, "attachment1", "desc1", "http://example1.com");
    
    engineRule.getIdentityService().clearAuthentication();
    engineRule.getTaskService().createAttachment(
        "web page", taskId, null, "attachment2", "desc2", "http://example2.com");
    
    engineRule.getIdentityService().setAuthenticatedUserId("user2");
    engineRule.getTaskService().createAttachment(
        "web page", taskId, null, "attachment3", "desc3", "http://example3.com");

    // when
    var attachments = engineRule.getTaskService().getTaskAttachments(taskId);

    // then - should retrieve all without errors
    assertEquals(3, attachments.size());
    assertEquals("user1", attachments.get(0).getCreatedBy());
    assertNull(attachments.get(1).getCreatedBy()); // simulates legacy data
    assertEquals("user2", attachments.get(2).getCreatedBy());

    // cleanup
    engineRule.getIdentityService().clearAuthentication();
  }
}
