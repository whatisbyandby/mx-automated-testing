package automatedtestingtests;

import automatedtesting.ExecutionStatus;
import automatedtesting.MicroflowExecution;
import org.junit.Test;
import static org.junit.Assert.*;




public class MicroflowExectutionTest {


    @Test
    public void MicroflowExecutionConstructor() {
        String qualifiedName = "MyFirstModule.Some_Thing";
        String executionId = "1234-1234-1233";
        ExecutionStatus status = ExecutionStatus.STARTING;

        MicroflowExecution execution = new MicroflowExecution(qualifiedName, executionId, status);

        assertEquals(execution.getExecutionId(), executionId);
        assertEquals(execution.getMicroflowName(), "Some_Thing");
        assertEquals(execution.getModuleName(), "MyFirstModule");
        assertEquals(execution.getQualifiedName(), qualifiedName);
    }

}
