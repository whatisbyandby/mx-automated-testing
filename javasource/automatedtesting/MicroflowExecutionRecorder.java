package automatedtesting;


import java.util.HashMap;
import java.util.Map;


public class MicroflowExecutionRecorder {

    private Map<String, TestSuite> suiteMap;


    public MicroflowExecutionRecorder() {
        this.suiteMap = new HashMap<>();

    }


    public void recordExecution(MicroflowExecution execution) {
        TestSuite testSuite = getTestSuite(execution.getModuleName());
        UnitTest unitTest = getUnitTest(execution, testSuite);
        if (unitTest.name.equals(execution.getMicroflowName())) {
            // This is the Unit Test log, we don't need to record it
            return;
        }
        unitTest.addMicroflowExecution(execution);
    }

    public void clear() {
        suiteMap.clear();
    }

    public Map<String, TestSuite> getReport() {
        return this.suiteMap;
    }

    private UnitTest getUnitTest(MicroflowExecution execution, TestSuite testSuite) {
        if (!testSuite.containsKey(execution.getExecutionId()) && execution.getStatus() == ExecutionStatus.STARTING) {
            UnitTest ut = new UnitTest(execution.getMicroflowName(), execution.getExecutionId());
            testSuite.addUnitTest(execution.getExecutionId(), ut);
            return ut;

        }
        return testSuite.get(execution.getExecutionId());
    }

    private TestSuite getTestSuite(String testSuiteName) {
        if (suiteMap.containsKey(testSuiteName)){
            return suiteMap.get(testSuiteName);
        }
        TestSuite ts = new TestSuite(testSuiteName);
        suiteMap.put(testSuiteName, ts);
        return ts;


    }
}
