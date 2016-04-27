import org.junit.Before;
import org.junit.Test;

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
    public void displaysTheGrid() {
        assertEquals(emptyBoard(), board.display());
    }

    @Test
    public void placesAMark() {
        board.placeMark("X", 0);
        assertEquals("X", board.grid[0]);
    }

    @Test
    public void updatesDisplay() {
        board.placeMark("X", 1);
        assertEquals(board(), board.display());
    }

    @Test
    public void returnsHorizontalRows() {
        fillBoard();
        String[] topRow = {"0", "1", "2"};
        String[] middleRow = {"3", "4", "5"};
        String[] bottomRow = {"6", "7", "8"};
        String[][] rows = {topRow, middleRow, bottomRow};
        assertEquals(rows, board.horizontalRows());
    }

    @Test
    public void returnsVerticalRows() {
        fillBoard();
        String[] leftRow = {"0", "3", "6"};
        String[] middleRow = {"1", "4", "7"};
        String[] rightRow = {"2", "5", "8"};
        String[][] rows = {leftRow, middleRow, rightRow};
        assertEquals(rows, board.verticalRows());
    }

    @Test
    public void returnsDiagonals() {
        fillBoard();
        String[] leftDiagonal = {"0", "4", "8"};
        String[] rightDiagonal = {"2", "4", "6"};
        String[][] diagonals = {leftDiagonal, rightDiagonal};
        assertEquals(diagonals, board.diagonals());
    }

    private String emptyBoard() {
        return "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------";
    }

    private String board() {
        return "-------------" + "\n" +
                "|   | X |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------";
    }

    private void fillBoard() {
        for (int cell = 0; cell < 9; cell++) {
            board.placeMark(String.valueOf(cell), cell);
        }
    }
}

