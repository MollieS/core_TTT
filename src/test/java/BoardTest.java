import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        this.board = new Board();
    }

    @Test
    public void hasNineSpaces() {
        assertEquals(9, board.grid.length);
    }

    @Test
    public void placesAMark() {
        board.placeMark("X", 0);
        assertEquals("X", board.grid[0]);
    }

    @Test
    public void returnsRows() {
        fillBoard();
        assertEquals(getRows(), board.rows());
    }

    @Test
    public void returnsColumns() {
        fillBoard();
        assertEquals(getColumns(), board.columns());
    }

    @Test
    public void returnsDiagonals() {
        fillBoard();
        assertEquals(getDiagonals(), board.diagonals());
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
    public void knowsWhenFull() {
        fillBoard();
        assertTrue(board.full());
    }

    private void fillBoard() {
        for (int cell = 0; cell < 9; cell++) {
            board.placeMark(String.valueOf(cell), cell);
        }
    }

    private List<List<String>> getRows() {
        List<String> topRow = getCells("0", "1", "2");
        List<String> middleRow = getCells("3", "4", "5");
        List<String> bottomRow = getCells("6", "7", "8");
        return Arrays.asList(topRow, middleRow, bottomRow);
    }


    private List<String> getCells(String s, String s2, String s3) {
        return Arrays.asList(s, s2, s3);
    }

    private List<List<String>> getColumns() {
        List<String> left = getCells("0", "3", "6");
        List<String> middle = getCells("1", "4", "7");
        List<String> right = getCells("2", "5", "8");
        return Arrays.asList(left, middle, right);
    }

    private List<List<String>> getDiagonals() {
        List<String> left = getCells("0", "4", "8");
        List<String> right = getCells("2", "4", "6");
        return Arrays.asList(left, right);
    }
}

