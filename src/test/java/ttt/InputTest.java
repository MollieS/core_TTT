package ttt;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        assertFalse(input.isAnInteger("HELLO"));
    }

    @Test
    public void getsReplayAnswer() {
        input.set("y");
        assertTrue(input.getReplay().contains("y"));
    }

    @Test
    public void getsValidBoardChoice() {
        input.set("1");
        assertEquals(1, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidInput() {
        input.set("Hello");
        assertEquals(0, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidBoardOption() {
        input.set("3");
        assertEquals(0, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void getValidGameChoice() {
        input.set("1");
        assertEquals(1, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidGameInput() {
        input.set("Hello");
        assertEquals(0, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidGameChoice() {
        input.set("30");
        assertEquals(0, input.getMenuChoice(Arrays.asList(1, 2)));
    }
}
