package automatedtesting;

public class MicroflowEngineLogParser {

    public static MicroflowExecution parseLog(String logMessage) {

        String[] parts = logMessage.split(" ");

        String executionId = parts[0].substring(1, parts[0].length() - 1);
        String qualifiedName = parts[5].substring(1, parts[5].length() - 1);
        String status = parts[1];



        return new MicroflowExecution(qualifiedName, executionId, ExecutionStatus.valueOf(status.toUpperCase()));
    }

}


