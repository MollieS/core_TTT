package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void returnsInput() {
        InputFake input = new InputFake();
        input.set("Hello");
        assertEquals("Hello", input.get());
    }
}
