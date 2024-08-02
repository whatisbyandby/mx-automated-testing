package automatedtestingtests;

import automatedtesting.*;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoverageFileWriterTest {

    @Test
    public void testWriteCoverageFile() {

        UnitTest unitTest = new UnitTest("MyFirstModule.UT_SomeUnitTest", "e36e8fd2-0761-4248-9c74-41a3ab44b6a0");
        TestSuite testSuite = new TestSuite("MyFirstModule");
        testSuite.addUnitTest(unitTest.getName(), unitTest);
        Map<String, TestSuite> TestSuites = new HashMap<>();

        TestSuites.put("MyFirstModule", testSuite);


        CoverageFileWriter.writeCoverageFile(TestSuites);
    }
}
