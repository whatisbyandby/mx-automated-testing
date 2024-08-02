package automatedtestingtests;

import automatedtesting.ExecutionStatus;
import automatedtesting.MicroflowEngineLogParser;
import automatedtesting.MicroflowExecution;
import org.junit.Test;

import static org.junit.Assert.*;

public class MicroflowEngineLogParserTest
{

    @Test
    public void TestParseMessageFinished() {
        String logMessage = "[e36e8fd2-0761-4248-9c74-41a3ab44b6a0] Finished execution of microflow 'AutomatedTesting.ReportStep'";
        MicroflowExecution execution = MicroflowEngineLogParser.parseLog(logMessage);

        assertEquals("ReportStep", execution.getMicroflowName());
        assertEquals("e36e8fd2-0761-4248-9c74-41a3ab44b6a0", execution.getExecutionId());
        assertEquals("AutomatedTesting", execution.getModuleName());
        assertEquals("AutomatedTesting.ReportStep", execution.getQualifiedName());
        assertSame(execution.getStatus(), ExecutionStatus.FINISHED);
    }

    @Test
    public void TestParseMessageStarted() {
        String logMessage = "[e36e8fd2-0761-4248-9c74-41a3ab44b6a0] Starting execution of microflow 'AutomatedTesting.ReportStep'";


        MicroflowExecution execution = MicroflowEngineLogParser.parseLog(logMessage);

        assertEquals("ReportStep", execution.getMicroflowName());
        assertEquals("e36e8fd2-0761-4248-9c74-41a3ab44b6a0", execution.getExecutionId());
        assertEquals("AutomatedTesting", execution.getModuleName());
        assertEquals("AutomatedTesting.ReportStep", execution.getQualifiedName());
        assertSame(execution.getStatus(), ExecutionStatus.STARTING);
    }


}
