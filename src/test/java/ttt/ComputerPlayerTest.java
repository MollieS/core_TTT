package ttt;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ComputerPlayerTest {

    @Test
    public void returnsARandomStringInteger() {
        Input input = new InputFake();
        Board board = new Board();
        ComputerPlayer computer = new ComputerPlayer(new FakeRandomizer(), "X");
        GameEngine game = new GameEngine(computer, computer, board);
        assertEquals(1, computer.getLocation(input, game));
    }

    @Test
    public void doesNotChooseTakenCell() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        Board board = new Board();
        board.placeMark("X", 1);
        assertFalse(computerPlayer.availableLocations(board).contains(1));
    }

    @Test
    public void doesNotRegisterAnyTakenCells() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        Board board = new Board();
        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), computerPlayer.availableLocations(board));
        board.placeMark("X", 1);
        assertEquals(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8), computerPlayer.availableLocations(board));
        board.placeMark("O", 0);
        assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7, 8), computerPlayer.availableLocations(board));
        board.placeMark("X", 8);
        assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7), computerPlayer.availableLocations(board));
    }

    @Test
    public void hasMark() {
        ComputerPlayer computerPlayer = new ComputerPlayer(new FakeRandomizer(), "X");
        assertEquals(computerPlayer.getMark(), "X");
    }
}
