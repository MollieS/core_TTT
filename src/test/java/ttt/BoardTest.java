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
        this.board = new Board(3);
        this.X = Marks.X;
        this.O = Marks.O;
    }

    @Test
    public void placesAMark() {
        board.placeMark(X, 0);
        assertEquals(X, board.getMarkAt(0));
    }

    @Test
    public void newBoardIsEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    public void boardIsNotEmptyAfterMarkPlaced() {
        board.placeMark(X, 4);
        assertFalse(board.isEmpty());
    }

    @Test
    public void boardIsNotEmptyForEitherMark() {
        board.placeMark(O, 6);
        assertFalse(board.isEmpty());
    }

    @Test
    public void clearsCell() {
        board.placeMark(X, 4);
        board.clear(4);
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
        board.placeMark(X, 4);
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

    private void horizontalWin() {
        board.placeMark(X, 0);
        board.placeMark(O, 3);
        board.placeMark(X, 1);
        board.placeMark(O, 4);
        board.placeMark(X, 2);
    }

    private void drawnGame() {
        board.placeMark(X, 0);
        board.placeMark(O, 1);
        board.placeMark(X, 2);
        board.placeMark(O, 3);
        board.placeMark(X, 5);
        board.placeMark(O, 6);
        board.placeMark(X, 7);
        board.placeMark(O, 8);
        board.placeMark(X, 4);
    }
}
