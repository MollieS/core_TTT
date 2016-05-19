package ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleBoardTest {

    private Marks X = Marks.X;
    private Marks O = Marks.O;
    private ConsoleBoard consoleBoard;
    private Board board;

    @Before
    public void setUp() {
        this.consoleBoard = new ConsoleBoard();
        this.board = new Board();
    }

    @Test
    public void displaysBoard() {
        assertEquals(emptyBoard(), consoleBoard.createBoard(board));
    }

    @Test
    public void updatesBoard() {
        board.placeMark(X, 1);
        assertEquals(board(), consoleBoard.createBoard(board));
    }

    @Test
    public void maintainsChange() {
        board.placeMark(X, 1);
        board.placeMark(O, 0);
        assertEquals(drawnBoard(), consoleBoard.createBoard(board));
    }

    private String drawnBoard() {
        return "-------------" + "\n" +
                "| O | X | 3 |" + "\n" +
                "-------------" + "\n" +
                "| 4 | 5 | 6 |" + "\n" +
                "-------------" + "\n" +
                "| 7 | 8 | 9 |" + "\n" +
                "-------------";
    }

    private String emptyBoard() {
        return "-------------" + "\n" +
                "| 1 | 2 | 3 |" + "\n" +
                "-------------" + "\n" +
                "| 4 | 5 | 6 |" + "\n" +
                "-------------" + "\n" +
                "| 7 | 8 | 9 |" + "\n" +
                "-------------";
    }

    private String board() {
        return "-------------" + "\n" +
                "| 1 | X | 3 |" + "\n" +
                "-------------" + "\n" +
                "| 4 | 5 | 6 |" + "\n" +
                "-------------" + "\n" +
                "| 7 | 8 | 9 |" + "\n" +
                "-------------";
    }

}
