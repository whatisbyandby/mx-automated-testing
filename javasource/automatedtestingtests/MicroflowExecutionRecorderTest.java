package automatedtestingtests;

import automatedtesting.*;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;


public class MicroflowExecutionRecorderTest {

    @Test
    public void TestRecordExecution_UnitTest() {

        MicroflowExecutionRecorder recorder = new MicroflowExecutionRecorder();
        MicroflowExecution executionStart = new MicroflowExecution("MyFirstModule.UT_Person_Create", "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.STARTING);
        MicroflowExecution executionFinish = new MicroflowExecution("MyFirstModule.UT_Person_Create",  "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.FINISHED);
        recorder.recordExecution(executionStart);
        recorder.recordExecution(executionFinish);

        Map<String, TestSuite> report = recorder.getReport();

        assertTrue(report.containsKey("MyFirstModule"));
        TestSuite suite = report.get("MyFirstModule");

        assertNotNull(suite);

        assertTrue(suite.containsKey("e36e8fd2-0761-4248-9c74-41a3ab44b6a0"));
    }

    @Test
    public void TestRecordExecution_NotUnitTest() {

        MicroflowExecutionRecorder recorder = new MicroflowExecutionRecorder();
        MicroflowExecution utExecutionStart = new MicroflowExecution("MyFirstModule.UT_Person_Create", "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.STARTING);
        MicroflowExecution executionStart = new MicroflowExecution("MyFirstModule.Person_Create", "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.STARTING);
        MicroflowExecution executionFinish = new MicroflowExecution("MyFirstModule.Person_Create", "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.FINISHED);
        MicroflowExecution utExecutionFinish = new MicroflowExecution("MyFirstModule.UT_Person_Create",  "e36e8fd2-0761-4248-9c74-41a3ab44b6a0", ExecutionStatus.FINISHED);

        recorder.recordExecution(utExecutionStart);
        recorder.recordExecution(executionStart);
        recorder.recordExecution(executionFinish);
        recorder.recordExecution(utExecutionFinish);

        Map<String, TestSuite> report = recorder.getReport();

        assertTrue(report.containsKey("MyFirstModule"));
        TestSuite suite = report.get("MyFirstModule");

        assertNotNull(suite);

        assertTrue(suite.containsKey("e36e8fd2-0761-4248-9c74-41a3ab44b6a0"));
        UnitTest unitTest = suite.get("e36e8fd2-0761-4248-9c74-41a3ab44b6a0");

        assertTrue(unitTest.hasMicroflowExecution("Person_Create"));
    }
}
