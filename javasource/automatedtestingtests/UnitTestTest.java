package automatedtestingtests;

import automatedtesting.UnitTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTestTest {

    @Test
    public void TestUnitTestConstructor() {
        UnitTest ut = new UnitTest("Some_Thing", "1231231234");
    }

}
