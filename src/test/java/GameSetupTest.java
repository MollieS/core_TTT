import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameSetupTest {

    private GameSetup runner;
    private Input testInput;
    private Outputter testOutput;

    @Before
    public void setUp() {
        this.testInput = new TestInput();
        this.testOutput = new TestOutput();
        this.runner = new GameSetup(testInput, testOutput);
    }

    @Test
    public void greetsUser() {
        runner.greet();
        assertTrue((testOutput.read()).contains("Welcome to Tic Tac Toe"));
    }

    @Test
    public void promptsUserToChooseSymbol() {
        testInput.set("X");
        runner.createPlayer();
        assertTrue((testOutput.read()).contains("Player One please choose a symbol"));
    }

    @Test
    public void promptsForValidInput() {
        testInput.set("Hello", "X");
        runner.createPlayer();
        assertTrue((testOutput.read()).contains("Please choose X or O"));
    }

    @Test
    public void loopsUntilValidInput() {
        testInput.set("Hello", "hello", "X");
        runner.createPlayer();
        assertTrue((testOutput.read().contains("Player One's symbol is X")));
    }

    @Test
    public void createsPlayer() {
        testInput.set("X");
        runner.createPlayer();
        assertTrue(runner.playerOne.getSymbol() == "X");
    }

    @Test
    public void createsSecondPlayer() {
        testInput.set("X");
        runner.createPlayer();
        assertTrue(runner.playerTwo.getSymbol() == "O");
    }

    @Test
    public void playerXGoesFirst() {
        testInput.set("X", "X");
        runner.createPlayer();
        runner.setFirstPlayer();
        assertTrue(testOutput.read().contains("X goes first"));
    }

    @Test
    public void playerOGoesFirst() {
        testInput.set("O", "O");
        runner.createPlayer();
        runner.setFirstPlayer();
        assertTrue(testOutput.read().contains("O goes first"));
    }

    @Test
    public void playerOGoesSecond() {
        testInput.set("O", "X");
        runner.createPlayer();
        runner.setFirstPlayer();;
        assertTrue(testOutput.read().contains("X goes first"));
    }

    @Test
     public void playerXGoesSecond() {
        testInput.set("X", "O");
        runner.createPlayer();
        runner.setFirstPlayer();
        assertTrue(testOutput.read().contains("O goes first"));
    }

    @Test
    public void setsUpGame() {
        testInput.set("X", "X");
        assertFalse(runner.setUpGame().over());
    }
}
