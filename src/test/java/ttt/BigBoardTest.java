package ttt;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BigBoardTest {

    private Board board;
    private Marks X;
    private Marks O;


    @Before
    public void setUp() {
        this.board = new Board(4);
        this.X = Marks.X;
        this.O = Marks.O;

    }

    @Test
    public void hasSixteenSpaces() {
        assertEquals(16, board.size());
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
    public void winningPositionsContainsLeftDiagonalWin() {
        leftDiagonalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O, O)));
    }

    @Test
    public void winningPositionsContainsRightDiagonalWin() {
        rightDiagonalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O, O)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnTopRow() {
        horizontalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X, X)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnSecondRow() {
        board.placeMark(X, 4);
        board.placeMark(X, 5);
        board.placeMark(X, 6);
        board.placeMark(X, 7);
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X, X)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnThirdRow() {
        board.placeMark(O, 8);
        board.placeMark(O, 9);
        board.placeMark(O, 10);
        board.placeMark(O, 11);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O, O)));
    }

    @Test
    public void winningPositionsContainsLeftColumnWin() {
        board.placeMark(O, 0);
        board.placeMark(O, 4);
        board.placeMark(O, 8);
        board.placeMark(O, 12);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O, O)));
    }

    @Test
    public void winningPositionsContainsSecondColumnWin() {
        board.placeMark(O, 1);
        board.placeMark(O, 5);
        board.placeMark(O, 9);
        board.placeMark(O, 13);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O, O)));
    }

    @Test
    public void winningPositionsContainsThirdColumnWin() {
        board.placeMark(X, 2);
        board.placeMark(X, 6);
        board.placeMark(X, 10);
        board.placeMark(X, 14);
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X, X)));
    }

    @Test
    public void availableMoves() {
        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), board.availableMoves());
        board.placeMark(X, 0);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), board.availableMoves());
    }

    @Test
    public void clearsCell() {
        board.placeMark(X, 4);
        board.clear(4);
        assertEquals(Marks.CLEAR, board.getMarkAt(4));
    }

    @Test
    public void knowsWinnerForFirstMark() {
        board.placeMark(X, 0);
        board.placeMark(X, 1);
        board.placeMark(X, 2);
        board.placeMark(X, 3);
        assertTrue(board.isAWinFor(X));
    }

    @Test
    public void knowsWinnerForSecondMark() {
        board.placeMark(O, 4);
        board.placeMark(O, 5);
        board.placeMark(O, 6);
        board.placeMark(O, 7);
        assertTrue(board.isAWinFor(O));
    }

    @Test
    public void knowsWhenFull() {
        fillBoard();
        assertTrue(board.isFull());
    }

    @Test
    public void knowsIfNotFull() {
        board.placeMark(X, 1);
        assertFalse(board.isFull());
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

    private void fillBoard() {
        for (int i = 0; i < 16; i++) {
            board.placeMark(X, i);
        }
    }

    private void horizontalWin() {
        board.placeMark(X, 0);
        board.placeMark(X, 1);
        board.placeMark(X, 2);
        board.placeMark(X, 3);
    }

    private void leftDiagonalWin() {
        board.placeMark(O, 0);
        board.placeMark(O, 5);
        board.placeMark(O, 10);
        board.placeMark(O, 15);
    }

    private void rightDiagonalWin() {
        board.placeMark(O, 3);
        board.placeMark(O, 6);
        board.placeMark(O, 9);
        board.placeMark(O, 12);
    }

    private void drawnGame() {
        board.placeMark(X, 0);
        board.placeMark(O, 1);
        board.placeMark(X, 2);
        board.placeMark(O, 3);
        board.placeMark(X, 4);
        board.placeMark(O, 5);
        board.placeMark(X, 6);
        board.placeMark(O, 7);
        board.placeMark(X, 8);
        board.placeMark(O, 9);
        board.placeMark(X, 10);
        board.placeMark(O, 11);
        board.placeMark(X, 13);
        board.placeMark(O, 12);
        board.placeMark(X, 15);
        board.placeMark(O, 14);
    }
}
