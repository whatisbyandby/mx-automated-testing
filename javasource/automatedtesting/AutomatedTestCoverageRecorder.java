package automatedtesting;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.logging.LogLevel;
import com.mendix.logging.LogMessage;
import com.mendix.logging.LogSubscriber;

public class AutomatedTestCoverageRecorder extends LogSubscriber {

    private ILogNode logger = Core.getLogger("AutomatedTestCoverageRecorder");
    private MicroflowExecutionRecorder recorder;
    private ILogNode logNode;
    private String TestSuiteName;

    public AutomatedTestCoverageRecorder(String TestSuiteName, MicroflowExecutionRecorder recorder) {
        super("AutomatedTestCoverageSubscriber", LogLevel.DEBUG);
        this.recorder = recorder;
        this.logNode = Core.getLogger("MicroflowEngine");
        this.TestSuiteName = TestSuiteName;
    }

    public void start() {
        this.logNode.subscribe(this, LogLevel.DEBUG);
    }

    public void stop() {
        this.logNode.unsubscribe(this);
    }

    public void clear() {
        recorder.clear();
    }

    @Override
    public void processMessage(LogMessage logMessage) {
        logger.trace("Received log message: " + logMessage.message);
        MicroflowExecution execution = MicroflowEngineLogParser.parseLog(logMessage.message.toString());

        // Only capture microflows that are in the same module for coverage calculations
        if (execution.getModuleName().equals(TestSuiteName)) {
            recorder.recordExecution(execution);
        }
    }
}
