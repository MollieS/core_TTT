package ttt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 3, 4, 5", "4, 4, 5, 6, 7"})
    public void winOnSecondRow(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 6, 7, 8", "4, 8, 9, 10, 11"})
    public void winOnThirdRow(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"4, 12, 13, 14, 15"})
    public void winOnFourthRow(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 0, 3, 6", "4, 0, 4, 8, 12"})
    public void winOnFirstColumn(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 1, 4, 7", "4, 1, 5, 9, 13"})
    public void winOnSecondColumn(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 2, 5, 8", "4, 2, 6, 10, 14"})
    public void winOnThirdColumn(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"4, 3, 7, 11, 15"})
    public void winOnFourthColumn(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 0, 4, 8", "3, 2, 4, 6", "4, 0, 5, 10, 15", "4, 3, 6, 9, 12"})
    public void diagonals(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        List<Marks> expected = expectedMarks(size);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.winningPositions().contains(expected));
    }

    @Test
    @Parameters({"3, 3, 4, 5", "4, 0, 1, 2, 3"})
    public void winForFirstMark(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        board = placeMarks(board, locations, Marks.X);
        assertTrue(board.isAWinFor(Marks.X));
    }

    @Test
    @Parameters({"3, 3, 4, 5", "4, 0, 1, 2, 3"})
    public void winForSecondMark(int size, String...locations) {
        Board board = new Board(size, new Marks[0]);
        board = placeMarks(board, locations, Marks.O);
        assertTrue(board.isAWinFor(Marks.O));
    }

    private Board placeMarks(Board board, String[] locations, Marks mark) {
        for (String location : locations) {
            board = board.placeMark(mark, Integer.parseInt(location));
        }
        return board;
    }

    private List<Marks> expectedMarks(int size) {
        List<Marks> expected = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            expected.add(Marks.X);
        }
        return expected;
    }
}

