package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Marks;

import static junit.framework.TestCase.assertTrue;

public class DisplayTest {

    private DisplayFake display;

    @Before
    public void setUp() {
        this.display = new DisplayFake();
    }

    @Test
    public void displaysAGreeting() {
        display.greet();
        assertTrue(displayContains("Welcome"));
    }

    @Test
    public void displaysPlayerMarks() {
        display.displayMarks(Marks.X, Marks.O);
        assertTrue(displayContains("Player Two's mark is O"));
    }

    @Test
    public void printsOutput() {
        display.write("Hello");
        assertTrue((display.read()).contains("Hello"));
    }

    @Test
    public void promptsForLocation() {
        display.promptForLocation(9);
        assertTrue(displayContains("Please choose a location from 1 to 9"));
        display.promptForLocation(16);
        assertTrue(displayContains("Please choose a location from 1 to 16"));
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
    public void displaysDraw() {
        display.draw();
        assertTrue(displayContains("It's a draw!"));
    }

    @Test
    public void displaysCurrentPlayerMark() {
        assertTrue((display.currentMark(Marks.X)).contains(Marks.X.toString()));
    }

    @Test
    public void displaysTurn() {
        display.displayTurn(Marks.X);
        assertTrue(displayContains("X's turn"));
    }

    @Test
    public void displaysTakenCellError() {
        display.takenCell();
        assertTrue(displayContains("Already taken"));
    }

    @Test
    public void displaysWinner() {
        display.winner(Marks.X);
        assertTrue(displayContains("X wins!"));
    }

    @Test
    public void asksForReplay() {
        display.replay();
        assertTrue(displayContains("Would you like to play again?"));
    }

    @Test
    public void saysGoodbye() {
        display.goodbye();
        assertTrue(displayContains("Thanks for playing!"));
    }

    @Test
    public void displaysBoardOptions() {
        display.boardOptions();
        assertTrue(displayContains("3 x 3"));
    }
}
