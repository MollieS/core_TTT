import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameSetupTest {

    private GameSetup gameSetup;
    private InputFake input;
    private DisplayFake display;

    @Before
    public void setUp() {
        this.input = new InputFake();
        this.display = new DisplayFake();
        this.gameSetup = new GameSetup(input, display);
    }

    @Test
    public void promptsForValidInput() {
        input.set("Hello", "X");
        gameSetup.createPlayer();
        assertTrue((display.read()).contains("X or O"));
    }

    @Test
    public void createsPlayer() {
        input.set("X");
        gameSetup.createPlayer();
        assertTrue(gameSetup.playerOne.getMark() == "X");
    }

    @Test
    public void createsSecondPlayer() {
        input.set("X");
        gameSetup.createPlayer();
        assertTrue(gameSetup.playerTwo.getMark() == "O");
    }

    @Test
    public void playerXGoesFirst() {
        input.set("X", "X");
        Game game = gameSetup.setUpGame();
        assertTrue(game.currentPlayer.getMark() == "X");
    }

    @Test
    public void playerOGoesFirst() {
        input.set("O", "O");
        Game game = gameSetup.setUpGame();
        assertTrue(game.currentPlayer.getMark() == "O");
    }

    @Test
    public void playerOGoesSecond() {
        input.set("O", "X");
        Game game = gameSetup.setUpGame();
        assertTrue(game.currentPlayer.getMark() == "X");
    }

    @Test
     public void playerXGoesSecond() {
        input.set("X", "O");
        Game game = gameSetup.setUpGame();
        assertTrue(game.currentPlayer.getMark() == "O");
    }

    @Test
    public void setsUpGame() {
        input.set("X", "X");
        assertFalse(gameSetup.setUpGame().over());
    }
}
