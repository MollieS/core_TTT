package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.consoleui.ConsoleBoard;
import ttt.game.Board;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;

public class ConsoleBoardTest {

    private Marks X = Marks.X;
    private Marks O = Marks.O;
    private ConsoleBoard consoleBoard;
    private Board board;

    @Before
    public void setUp() {
        this.consoleBoard = new ConsoleBoard();
        this.board = new Board(3, new Marks[0]);
    }

    @Test
    public void displaysBoard() {
        assertEquals(emptyBoard(), consoleBoard.createBoard(board));
    }

    @Test
    public void updatesBoard() {
        board = board.placeMark(X, 1);
        assertEquals(board(), consoleBoard.createBoard(board));
    }

    @Test
    public void maintainsChange() {
        board = board.placeMark(X, 1);
        board = board.placeMark(O, 0);
        assertEquals(drawnBoard(), consoleBoard.createBoard(board));
    }

    @Test
    public void drawsBigBoard() {
        Board bigBoard = new Board(4, new Marks[0]);
        assertEquals(bigBoard(), consoleBoard.createBoard(bigBoard));
    }

    @Test
    public void updatesBigBoard() {
        Board bigBoard = new Board(4, new Marks[0]);
        bigBoard = bigBoard.placeMark(X, 0);
        assertEquals(markedbigBoard(), consoleBoard.createBoard(bigBoard));
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


    private String markedbigBoard() {
        return "-----------------" + "\n" +
                "| X | 2 | 3 | 4 |" + "\n" +
                "-----------------" + "\n" +
                "| 5 | 6 | 7 | 8 |" + "\n" +
                "-----------------" + "\n" +
                "| 9 | 10| 11| 12|" + "\n" +
                "-----------------" + "\n" +
                "| 13| 14| 15| 16|" + "\n" +
                "-----------------";
    }

    private String bigBoard() {
        return "-----------------" + "\n" +
                "| 1 | 2 | 3 | 4 |" + "\n" +
                "-----------------" + "\n" +
                "| 5 | 6 | 7 | 8 |" + "\n" +
                "-----------------" + "\n" +
                "| 9 | 10| 11| 12|" + "\n" +
                "-----------------" + "\n" +
                "| 13| 14| 15| 16|" + "\n" +
                "-----------------";
    }
}
