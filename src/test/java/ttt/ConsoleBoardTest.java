package ttt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleBoardTest {

    @Test
    public void displaysBoard() {
        ConsoleBoard consoleBoard = new ConsoleBoard();
        assertEquals(emptyBoard(), consoleBoard.show());
    }

    @Test
    public void updatesBoard() {
        ConsoleBoard consoleBoard = new ConsoleBoard();
        consoleBoard.show();
        assertEquals(board(), consoleBoard.update("X", 1));
    }

    @Test
    public void maintainsChanged() {
        ConsoleBoard consoleBoard = new ConsoleBoard();
        consoleBoard.show();
        consoleBoard.update("X", 1);
        assertEquals(drawBoard(), consoleBoard.update("O", 0));
    }

    private String drawBoard() {
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
