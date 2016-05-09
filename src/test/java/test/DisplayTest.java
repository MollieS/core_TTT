package test;

import main.Board;
import main.Game;
import main.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DisplayTest {

    private Game game;
    private DisplayFake display;

    @Before
    public void setUp() {
        Board board = new Board();
        this.game = new Game(new HumanPlayer("X"), new HumanPlayer("O"), board);
        this.display = new DisplayFake();
    }

    @Test
    public void displaysAGreeting() {
        display.greet();
        assertTrue(displayContains("Welcome"));
    }

    @Test
    public void displaysPlayerMarks() {
        display.displayMarks("X", "O");
        assertTrue(displayContains("main.Player Two's mark is O"));
    }

    @Test
    public void printsOutput() {
        display.write("Hello");
        assertTrue((display.read()).contains("Hello"));
    }

    @Test
    public void displaysBoard() {
        display.board(game);
        assertTrue(displayContains(emptyBoard()));
    }

    @Test
    public void promptsForLocation() {
        display.promptForLocation();
        assertTrue(displayContains("Please choose a location from 1 to 9"));
    }

    @Test
    public void displaysInvalidLocationError() {
        display.invalidLocation();
        assertTrue(displayContains("Invalid location"));
    }

    @Test
    public void displaysInvalidInputError() {
        display.invalidInput();
        assertTrue(displayContains("Please choose a valid option"));
    }

    private boolean displayContains(String s) {
        return display.read().contains(s);
    }

    @Test
    public void updatesBoard() {
        game.play(1);
        display.board(game);
        assertTrue(displayContains(board()));
    }

    @Test
    public void displaysDraw() {
        display.draw();
        assertTrue(displayContains("It's a draw!"));
    }

    @Test
    public void displaysCurrentPlayerMark() {
        assertTrue(display.currentMark(game).contains("X"));
    }

    @Test
    public void displaysTurn() {
        display.displayTurn(game);
        assertTrue(displayContains("X's turn"));
    }

    @Test
    public void displaysTakenCellError() {
        display.takenCell();
        assertTrue(displayContains("Already taken"));
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

    private String emptyBoard() {
        return "-------------" + "\n" +
                "| 1 | 2 | 3 |" + "\n" +
                "-------------" + "\n" +
                "| 4 | 5 | 6 |" + "\n" +
                "-------------" + "\n" +
                "| 7 | 8 | 9 |" + "\n" +
                "-------------";
    }
}
