package ttt;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GameLoopTest {

    private GameLoop gameLoop;
    private DisplayFake display;
    private InputFake input;

    @Before
    public void setUp() {
        Board board = new Board(3);
        ConsoleBoard consoleBoard = new ConsoleBoard();
        Player player1 = new HumanPlayer(Marks.X);
        Player player2 = new HumanPlayer(Marks.O);
        GameEngine gameEngine = new GameEngine(player1, player2, board);
        this.input = new InputFake();
        this.display = new DisplayFake();
        this.gameLoop = new GameLoop(gameEngine, input, display, consoleBoard);
    }

    @Test
    public void promptsUserForLocation() {
        input.set("5", "1", "4", "2", "6", "2");
        gameLoop.start();
        assertTrue(displayContains("choose a location"));
    }

    @Test
    public void loopsUntilValidLocation() {
        input.set("10", "-1", "5", "1", "4", "2", "6", "7", "9");
        gameLoop.start();
        assertTrue(displayContains("Please choose a location from 1 to 9"));
    }

    @Test
    public void playsADraw() {
        input.set("1", "2", "3", "4", "6", "7", "8", "9", "5", "2");
        gameLoop.start();
        assertTrue(displayContains("It's a draw!"));
    }

    @Test
    public void returnsWinner() {
        input.set("5", "1", "4", "2", "6", "2");
        gameLoop.start();
        assertTrue(displayContains("X wins!"));
    }

    @Test
    public void cannotChooseTakenLocation() {
        input.set("1", "4", "2", "5", "2", "3", "2");
        gameLoop.start();
        assertTrue(displayContains("Already taken"));
    }

    @Test
    public void canReplayTheGame() {
        input.set("1", "4", "2", "5", "3", "1", "1", "1", "1", "4", "2", "5", "3", "2");
        gameLoop.start();
        assertTrue(displayContains("Would you like to play again?"));
        assertTrue(displayContains("Welcome to Tic Tac Toe"));
    }

    @Test
    public void canChooseToNotReplayTheGame() {
        input.set("1", "4", "2", "5", "2", "3", "2");
        gameLoop.start();
        assertTrue(displayContains("Thanks for playing!"));
    }

    @Test
    public void allowsLocationsForBiggerBoard() {
        Board board = new Board(4);
        ConsoleBoard consoleBoard = new ConsoleBoard();
        Player player1 = new HumanPlayer(Marks.X);
        Player player2 = new HumanPlayer(Marks.O);
        GameEngine gameEngine = new GameEngine(player1, player2, board);
        this.gameLoop = new GameLoop(gameEngine, input, display, consoleBoard);
        input.set("1", "4", "6", "8", "11", "12", "16", "2");
        gameLoop.start();
        assertTrue(displayContains("X wins!"));
    }

    private boolean displayContains(String message) {
        return display.read().contains(message);
    }
}
