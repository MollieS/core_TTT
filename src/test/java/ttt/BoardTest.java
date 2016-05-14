package ttt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        this.X = "!";
        this.O = "%";

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
    public void returnsWinningPositions() {
        fillBoard();
        List<List<String>> expectedWinningPositions = new ArrayList<>();
        expectedWinningPositions.addAll(getRows());
        expectedWinningPositions.addAll(getColumns());
        expectedWinningPositions.addAll(getDiagonals());
        assertEquals(expectedWinningPositions, board.winningPositions());
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
        Assert.assertTrue(board.isDraw());
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

    private List<List<String>> getRows() {
        List<String> topRow = getCells("0", "1", "2");
        List<String> middleRow = getCells("3", "4", "5");
        List<String> bottomRow = getCells("6", "7", "8");
        return Arrays.asList(topRow, middleRow, bottomRow);
    }

    private void fillBoard() {
        for (int i = 0; i < 9; i++) {
            board.placeMark(String.valueOf(i), i);
        }
    }

    private List<String> getCells(String s, String s2, String s3) {
        return Arrays.asList(s, s2, s3);
    }

    private List<List<String>> getColumns() {
        List<String> left = Arrays.asList("0", "3", "6");
        List<String> middle = Arrays.asList("1", "4", "7");
        List<String> right = Arrays.asList("2", "5", "8");
        return Arrays.asList(left, middle, right);
    }

    private List<List<String>> getDiagonals() {
        List<String> left = getCells("0", "4", "8");
        List<String> right = getCells("2", "4", "6");
        return Arrays.asList(left, right);
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
