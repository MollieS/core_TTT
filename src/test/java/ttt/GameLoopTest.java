package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.GameLoop;
import ttt.game.Marks;
import ttt.players.HumanPlayer;

import static junit.framework.TestCase.assertTrue;

public class GameLoopTest {

    private GameLoop gameLoop;
    private DisplayFake display;
    private InputFake input;
    private String no = "n";
    private GameEngine gameEngine;

    @Before
    public void setUp() {
        this.input = new InputFake();
        this.display = new DisplayFake();
        Board board = new Board(3);
        Player player1 = new HumanPlayer(Marks.X, input);
        Player player2 = new HumanPlayer(Marks.O, input);
        this.gameEngine = new GameEngine(player1, player2, board);
        this.gameLoop = new GameLoop(gameEngine, display, new BoardDisplayFake());
    }

    @Test
    public void promptsUserForLocation() {
        input.set("5", "1", "4", "2", "6", no);
        gameLoop.start();
        assertTrue(displayContains("choose a location"));
    }

    @Test
    public void loopsUntilValidLocation() {
        input.set("10", "-1", "5", "1", "4", "2", "6", "7", "9", no);
        gameLoop.start();
        assertTrue(displayContains("Please choose a location from 1 to 9"));
    }

    @Test
    public void playsADraw() {
        input.set("1", "2", "3", "4", "6", "7", "8", "9", "5", "2", no);
        gameLoop.start();
        assertTrue(displayContains("It's a draw!"));
    }

    @Test
    public void returnsWinner() {
        input.set("1", "6", "2", "4", "3", no);
        gameLoop.start();
        assertTrue(displayContains("X wins!"));
    }

    @Test
    public void cannotChooseTakenLocation() {
        input.set("1", "4", "2", "5", "2", "3", no);
        gameLoop.start();
        assertTrue(displayContains("Already taken"));
    }

    @Test
    public void cannotChooseOutOfBoundsLocation() {
        input.set("1", "4", "2", "5", "18", "3", no);
        gameLoop.start();
        assertTrue(displayContains("Out of bounds"));

    }

    @Test
    public void allowsLocationsForBiggerBoard() {
        input.set("1", "4", "6", "8", "11", "12", "16", no);
        Board board = new Board(4);
        BoardDisplay consoleBoard = new BoardDisplayFake();
        Player player1 = new HumanPlayer(Marks.X, input);
        Player player2 = new HumanPlayer(Marks.O, input);
        GameEngine gameEngine = new GameEngine(player1, player2, board);
        this.gameLoop = new GameLoop(gameEngine, display, consoleBoard);
        gameLoop.start();
        assertTrue(displayContains("X wins!"));
    }

    private boolean displayContains(String message) {
        return display.read().contains(message);
    }
}
