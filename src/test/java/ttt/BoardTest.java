package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Board board;
    private Marks X;
    private Marks O;

    @Before
    public void setUp() {
        this.board = new Board(3, new Marks[0]);
        this.X = Marks.X;
        this.O = Marks.O;
    }

    @Test
    public void placesAMark() {
        Board markedBoard = board.placeMark(X, 0);
        assertEquals(X, markedBoard.getMarkAt(0));
    }

    @Test
    public void immutableBoard() {
        assertTrue(board.isEmpty());
        board.placeMark(X, 4);
        assertTrue(board.isEmpty());
    }

    @Test
    public void newBoardIsEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    public void boardIsNotEmptyAfterMarkPlaced() {
        Board markedBoard = board.placeMark(X, 4);
        assertFalse(markedBoard.isEmpty());
    }

    @Test
    public void boardIsNotEmptyForEitherMark() {
        Board markedBoard = board.placeMark(O, 6);
        assertFalse(markedBoard.isEmpty());
    }

    @Test
    public void clearsCell() {
        board.placeMark(X, 4);
        assertEquals(Marks.CLEAR, board.getMarkAt(4));
    }

    @Test
    public void knowsIfDrawn() {
        drawnGame();
        assertTrue(board.isDraw());
    }

    @Test
    public void knowsWhenFinishedIfWon() {
        horizontalWin();
        assertTrue(board.isFinished());
    }

    @Test
    public void knowsWhenFinishedIfBoardIsDrawn() {
        drawnGame();
        assertTrue(board.isFinished());
    }

    @Test
    public void isNotFinishedIfBoardIsNotWonOrDrawn() {
        board = board.placeMark(X, 4);
        assertFalse(board.isFinished());
    }

    @Test
    public void knowsIfWon() {
        horizontalWin();
        assertTrue(board.isWon());
    }

    @Test
    public void knowsItsDimensions() {
        assertEquals(3, board.dimensions());
    }

    private Board horizontalWin() {
        board = board.placeMark(X, 0);
        board = board.placeMark(O, 3);
        board = board.placeMark(X, 1);
        board = board.placeMark(O, 4);
        board = board.placeMark(X, 2);
        return board;
    }

    private Board drawnGame() {
        board = board.placeMark(X, 0);
        board = board.placeMark(O, 1);
        board = board.placeMark(X, 2);
        board = board.placeMark(O, 3);
        board = board.placeMark(X, 5);
        board = board.placeMark(O, 6);
        board = board.placeMark(X, 7);
        board = board.placeMark(O, 8);
        board = board.placeMark(X, 4);
        return board;
    }
}
