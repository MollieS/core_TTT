package ttt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ttt.game.Board;
import ttt.game.Marks;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class BoardWinningPositionsTest {

    @Test
    @Parameters({"3, 0, 1, 2", "4, 0, 1, 2, 3"})
    public void winOnTopRow(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 3, 4, 5", "4, 4, 5, 6, 7"})
    public void winOnSecondRow(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 6, 7, 8", "4, 8, 9, 10, 11"})
    public void winOnThirdRow(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"4, 12, 13, 14, 15"})
    public void winOnFourthRow(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 0, 3, 6", "4, 0, 4, 8, 12"})
    public void winOnFirstColumn(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 1, 4, 7", "4, 1, 5, 9, 13"})
    public void winOnSecondColumn(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 2, 5, 8", "4, 2, 6, 10, 14"})
    public void winOnThirdColumn(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"4, 3, 7, 11, 15"})
    public void winOnFourthColumn(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 0, 4, 8", "3, 2, 4, 6", "4, 0, 5, 10, 15", "4, 3, 6, 9, 12"})
    public void diagonals(int size, String...locations) {
        Board board = new Board(size);
        List<Marks> expected = expectedMarks(size);
        placeMarks(board, locations);
        assertTrue(board.winningPositions().contains(expected));
    }

    private void placeMarks(Board board, String[] locations) {
        for (String location : locations) {
            board.placeMark(Marks.X, Integer.parseInt(location));
        }
    }

    private List<Marks> expectedMarks(int size) {
        List<Marks> expected = new ArrayList();
        for (int i = 0; i < size; i++) {
            expected.add(Marks.X);
        }
        return expected;
    }
}

