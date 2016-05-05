import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ComputerPlayerTest {

    @Test
    public void returnsARandomStringInteger() {
        InputFeed input = new InputFake();
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer(new FakeRandomizer(), "X");
        assertEquals("1", computer.getLocation(input, board));
    }

    @Test
    public void doesNotChooseTakenCell() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        Board board = new Board();
        board.placeMark("X", 1);
        assertFalse(computerPlayer.availableLocations(board).contains("2"));
    }

    @Test
    public void doesNotRegisterAnyTakenCells() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        Board board = new Board();
        assertEquals(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), computerPlayer.availableLocations(board));
        board.placeMark("X", 1);
        assertEquals(Arrays.asList("1", "3", "4", "5", "6", "7", "8", "9"), computerPlayer.availableLocations(board));
        board.placeMark("O", 0);
        assertEquals(Arrays.asList("3", "4", "5", "6", "7", "8", "9"), computerPlayer.availableLocations(board));
        board.placeMark("X", 8);
        assertEquals(Arrays.asList("3", "4", "5", "6", "7", "8"), computerPlayer.availableLocations(board));
    }

    @Test
    public void hasMark() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        assertEquals(computerPlayer.getMark(), "X");
    }
}
