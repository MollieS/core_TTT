package ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTest {

    private InputFake input;

    @Before
    public void setUp() {
        this.input = new InputFake();
    }

    @Test
    public void returnsInput() {
        input.set("1");
        assertEquals("1", input.getUserChoice());
    }

    @Test
    public void onlyTakesNumbers() {
        input.set("Hello!");
        assertEquals("-1", input.getUserChoice());
    }

    @Test
    public void doesNotAllowLettersForLocation() {
        assertFalse(input.validInput("HELLO"));
    }

    @Test
    public void getsReplayAnswer() {
        input.set("y");
        assertTrue(input.getReplay().contains("y"));
    }
}
