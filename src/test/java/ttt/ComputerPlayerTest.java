package ttt;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ComputerPlayerTest {

    @Test
    public void returnsARandomInteger() {
        Input input = new InputFake();
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer(new FakeRandomizer(), "X");
        assertEquals("1", computer.getLocation(input, board));
    }

    @Test
    public void hasMark() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        assertEquals(computerPlayer.getMark(), "X");
    }
}
