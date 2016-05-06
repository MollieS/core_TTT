import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DisplayTest {

    private Game game;
    private Display display;

    @Before
    public void setUp() {
        Board board = new Board();
        this.game = new Game(new Player("X"), new Player("O"), board);
        this.display = new DisplayFake();
    }

    @Test
    public void displaysAGreeting() {
        display.greet();
        assertTrue(displayContains("Welcome"));
    }

    @Test
    public void promptsMarkChoice() {
        display.promptForMark();
        assertTrue(displayContains("please choose a mark"));
    }

    @Test
    public void displaysPlayerMarks() {
        display.displayMarks("X", "O");
        assertTrue(displayContains("Player Two's mark is O"));
    }

    @Test
    public void promptsForFirstGo() {
        display.promptForFirstGo();
        assertTrue(displayContains("Who goes first?"));
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
        assertTrue(displayContains("Numbers only"));
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
                "|   | X |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------" + "\n" +
                "|   |   |   |" + "\n" +
                "-------------";
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
}
