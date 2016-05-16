package ttt;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Board board;
    private String X;
    private String O;


    @Before
    public void setUp() {
        this.board = new Board();
        this.X = "X";
        this.O = "O";

    }

    @Test
    public void hasNineSpaces() {
        assertEquals(9, board.size());
    }

    @Test
    public void placesAMark() {
        board.placeMark(X, 0);
        assertEquals(X, board.get(0));
    }

    @Test
    public void knowsWhenEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    public void knowsWhenNotEmptyForX() {
        board.placeMark(X, 4);
        assertFalse(board.isEmpty());
    }

    @Test
    public void knowsWhenNotEmptyForO() {
        board.placeMark(X, 6);
        assertFalse(board.isEmpty());
    }

    @Test
    public void doesNotPlaceMarkIfInvalidLocation() {
        board.placeMark(X, 10);
        assertEquals("invalid location", board.getStatus());
        assertTrue(board.isEmpty());
    }

    @Test
    public void winningPositionsContainsDiagonalWin() {
        diagonalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(O, O, O)));
    }

    @Test
    public void winningPositionsContainsHorizontalWin() {
        horizontalWin();
        assertTrue(board.winningPositions().contains(Arrays.asList(X, X, X)));
    }

    @Test
    public void winningPostitionsContainsVerticalWin() {
        verticalWin();
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
        assertTrue(board.isEmpty());
    }

    @Test
    public void knowsWinnerForHorizontalWin() {
        horizontalWin();
        assertTrue(board.isAWinFor(X));
    }

    @Test
    public void knowsWinnerForDiagonalWin() {
        diagonalWin();
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
    public void knowsIfCellIsTaken() {
        board.placeMark(X, 4);
        board.placeMark(O, 4);
        assertEquals("taken", board.getStatus());
    }

    private void fillBoard() {
        for (int i = 0; i < 9; i++) {
            board.placeMark(String.valueOf(i), i);
        }
    }

    private void horizontalWin() {
        board.placeMark(X, 0);
        board.placeMark(O, 3);
        board.placeMark(X, 1);
        board.placeMark(O, 4);
        board.placeMark(X, 2);
    }

    private void diagonalWin() {
        board.placeMark(X, 3);
        board.placeMark(O, 0);
        board.placeMark(X, 5);
        board.placeMark(O, 4);
        board.placeMark(X, 7);
        board.placeMark(O, 8);
    }

    private void verticalWin() {
        board.placeMark(X, 0);
        board.placeMark(O, 2);
        board.placeMark(X, 3);
        board.placeMark(O, 4);
        board.placeMark(X, 6);
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
