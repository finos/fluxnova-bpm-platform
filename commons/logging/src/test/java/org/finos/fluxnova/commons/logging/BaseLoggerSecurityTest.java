package org.finos.fluxnova.commons.logging;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

public class BaseLoggerSecurityTest {

  private ExampleLogger logger;
  private Logger delegate;

  @Before
  public void setUp() {
    logger = new ExampleLogger();
    logger.projectCode = ExampleLogger.PROJECT_CODE;
    logger.componentId = ExampleLogger.COMPONENT_ID;
    delegate = mock(Logger.class);
    logger.delegateLogger = delegate;
  }

  @Test
  public void shouldSanitizeFormattedLogParameters() {
    when(delegate.isInfoEnabled()).thenReturn(true);

    logger.logInfo("01", "User input: {}", "first\r\nsecond\tthird");

    verify(delegate).info("TEST-0101 User input: first__second_third");
  }

  @Test
  public void shouldPreserveTrailingThrowable() {
    when(delegate.isErrorEnabled()).thenReturn(true);
    RuntimeException failure = new RuntimeException("failure");

    logger.logError("02", "Failed for {}", "bad\nvalue", failure);

    verify(delegate).error("TEST-0102 Failed for bad_value", failure);
  }
}
