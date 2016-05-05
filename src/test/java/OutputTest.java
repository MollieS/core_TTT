import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class OutputTest {

    @Test
    public void printsOutput() {
        Outputter testOutput = new TestOutput();
        testOutput.write("Hello");
        assertTrue((testOutput.read()).contains("Hello"));
    }

}
