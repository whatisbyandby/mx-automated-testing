package automatedtesting;


import java.util.Map;

public class CoverageReport {

    private Map<String, TestSuite> TestSuites;

    public CoverageReport(Map<String, TestSuite> TestSuites) {
        this.TestSuites = TestSuites;
    }
}
