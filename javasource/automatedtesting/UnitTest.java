package automatedtesting;


import java.util.HashMap;
import java.util.Map;

public class UnitTest {
    String name;
    String executionId;
    Map<String, MicroflowExecution> MicroflowsCovered;

    public String getName() {
        return name;
    }

    public UnitTest(String name, String executionId) {
        this.name = name;
        this.executionId = executionId;
        this.MicroflowsCovered = new HashMap<>();
    }

    public void addMicroflowExecution(MicroflowExecution microflowExecution) {
        this.MicroflowsCovered.put(microflowExecution.getMicroflowName(), microflowExecution);
    }

    public Boolean hasMicroflowExecution(String microflowName) {
        return this.MicroflowsCovered.containsKey(microflowName);
    }

    public MicroflowExecution getMicroflowExectuion(String microflowName) {
        return this.MicroflowsCovered.get(microflowName);
    }


}
