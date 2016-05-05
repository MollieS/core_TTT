import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void returnsInput() {
        TestInput input = new TestInput();
        input.set("Hello");
        assertEquals("Hello", input.get());
    }
}
