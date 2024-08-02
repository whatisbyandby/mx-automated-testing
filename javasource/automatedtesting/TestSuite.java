package automatedtesting;

import java.util.HashMap;
import java.util.Map;

public class TestSuite {

    Map<String, UnitTest> UnitTests;
    String name;

    public TestSuite(String name) {

        this.UnitTests = new HashMap<>();
        this.name = name;
    }

    public void addUnitTest(String executionId, UnitTest unitTest) {
        this.UnitTests.put(executionId, unitTest);
    }

    public UnitTest get(String executionId) {
        return this.UnitTests.get(executionId);
    }

    public Boolean containsKey(String executionId) {
        return this.UnitTests.containsKey(executionId);
    }
}
