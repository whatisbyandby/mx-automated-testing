package automatedtesting;

public class MicroflowExecution {

    private String microflowName;
    private String moduleName;
    private String qualifiedName;
    private String executionId;
    private ExecutionStatus status;


    public MicroflowExecution(String qualifiedName, String executionId, ExecutionStatus status) {
        this.qualifiedName = qualifiedName;
        this.executionId = executionId;

        String[] nameParts = qualifiedName.split("\\.");

        this.moduleName = nameParts[0];
        this.microflowName = nameParts[1];

        this.status = status;
    }

    public String getMicroflowName() {
        return microflowName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getExecutionId() {
        return executionId;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public  String getQualifiedName() {
        return qualifiedName;
    }

}
