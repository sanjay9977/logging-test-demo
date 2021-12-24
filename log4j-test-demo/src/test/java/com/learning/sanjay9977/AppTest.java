package com.learning.sanjay9977;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final String EXPECTED_LOG = "TEST - This is test log";
    private LogAppender logAppender;

    @Before
    public void init() {
        final LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
        logAppender = (LogAppender) loggerContext.getConfiguration().getAppenders().get("LogAppender");
    }

    @Test
    public void testLogMsg() {
        final App objectUnderTest = new App();
        objectUnderTest.logMsg("This is test log");
        assertTrue("logger did not log the expected msg", logAppender.isMsgEquals(EXPECTED_LOG));
    }

    @After
    public void cleanup() {
        logAppender.reset();
    }
}
