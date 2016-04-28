import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameInterfaceTest {

    private GameInterface runner;
    private Input testInput;
    private Outputter testOutput;

    @Before
    public void setUp() {
        this.testInput = new TestInput();
        this.testOutput = new TestOutput();
        this.runner = new GameInterface(testInput, testOutput);
    }

    @Test
    public void greetsUser() {
        runner.greet();
        assertTrue((testOutput.read()).contains("Welcome to Tic Tac Toe"));
    }

    @Test
    public void promptsPlayerOnetoChooseSymbol() {
        testInput.set("X");
        runner.createPlayer();
        assertTrue((testOutput.read()).contains("Player One please choose a symbol"));
    }

    @Test
    public void promptsForValidInput() {
        testInput.set("Hello", "X");
        runner.createPlayer();
        assertTrue((testOutput.read()).contains("Please choose X or 0"));
    }

    @Test
    public void loopsUntilValidInput() {
        testInput.set("Hello", "hello", "X");
        runner.createPlayer();
        assertTrue((testOutput.read().contains("Player One symbol is X")));
    }

    @Test
    public void createsPlayer() {
        testInput.set("X");
        runner.createPlayer();
        assertTrue(runner.playerOne.getSymbol() == "X");
    }

    @Test
    public void createsSecondPlayer() {
        testInput.set("0");
        runner.createPlayer();
        assertTrue(runner.playerTwo.getSymbol() == "X");
    }

    @Test
    public void whichPlayerGoesFirst() {
        testInput.set("X", "1");
        runner.createPlayer();
        runner.setFirstPlayer();
        assertTrue(testOutput.read().contains("Player One goes first"));
    }

    @Test
    public void playerTwoGoesFirst() {
        testInput.set("0", "2");
        runner.createPlayer();
        runner.setFirstPlayer();
        assertTrue(testOutput.read().contains("Player Two goes first"));
    }

    @Test
    public void promptsForALocation() {
    }
}
