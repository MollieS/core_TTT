package ttt;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void hasNineSpacesInA3x3Board() {
        assertEquals(9, board.size());
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
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsRightDiagonalWin() {
        rightDiagonalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnTopRow() {
        horizontalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnMiddleRow() {
        board.placeMark(X, 3);
        board.placeMark(X, 4);
        board.placeMark(X, 5);
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X)));
    }

    @Test
    public void winningPositionsContainsHorizontalWinOnBottomRow() {
        board.placeMark(O, 6);
        board.placeMark(O, 7);
        board.placeMark(O, 8);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsLeftColumnWin() {
        board.placeMark(O, 0);
        board.placeMark(O, 3);
        board.placeMark(O, 6);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsMiddleColumnWin() {
        board.placeMark(O, 1);
        board.placeMark(O, 4);
        board.placeMark(O, 7);
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsRightColumnWin() {
        board.placeMark(X, 2);
        board.placeMark(X, 5);
        board.placeMark(X, 8);
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X)));
    }

    @Test
    public void availableMoves() {
        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), board.availableMoves());
        board.placeMark(X, 0);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), board.availableMoves());
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
        assertTrue(board.isAWinFor(X));
    }

    @Test
    public void knowsWinnerForSecondMark() {
        board.placeMark(O, 3);
        board.placeMark(O, 4);
        board.placeMark(O, 5);
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

    @Test
    public void knowsItsDimensions() {
        assertEquals(3, board.dimensions());
    }

    private void fillBoard() {
        for (int i = 0; i < 9; i++) {
            board.placeMark(X, i);
        }
    }

    private void horizontalWin() {
        board.placeMark(X, 0);
        board.placeMark(O, 3);
        board.placeMark(X, 1);
        board.placeMark(O, 4);
        board.placeMark(X, 2);
    }

    private void leftDiagonalWin() {
        board.placeMark(X, 3);
        board.placeMark(O, 0);
        board.placeMark(X, 5);
        board.placeMark(O, 4);
        board.placeMark(X, 7);
        board.placeMark(O, 8);
    }

    private void rightDiagonalWin() {
        board.placeMark(O, 2);
        board.placeMark(O, 4);
        board.placeMark(O, 6);
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
