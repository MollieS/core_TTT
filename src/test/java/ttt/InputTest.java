package ttt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTest {

    @Test
    public void returnsInput() {
        InputFake input = new InputFake();
        input.set("1");
        assertEquals("1", input.get());
    }

    @Test
    public void onlyTakesNumbers() {
        InputFake input = new InputFake();
        input.set("Hello!");
        assertEquals("-1", input.get());
    }

    @Test
    public void validatesInput() {
        InputFake input = new InputFake();
        assertFalse(input.validInput("HELLO"));
    }

    @Test
    public void getsReplayAnswer() {
        InputFake input = new InputFake();
        input.set("y");
        assertTrue(input.getReplay().contains("y"));
    }
}
