import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GamePlayTest {

    private GamePlay gameplay;
    private TestOutput output;
    private Input input;

    @Before
    public void setUp() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("0");
        Game game = new Game(player1, player2, board);
        this.input = new TestInput();
        this.output = new TestOutput();
        this.gameplay = new GamePlay(game, input, output);
    }

    @Test
    public void displaysBoard() {
        input.set("5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue(output.read().contains(emptyBoard()));
    }

    @Test
    public void promptsUserForLocation() {
        input.set("5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue((output.read()).contains("choose a location"));
    }

    @Test
    public void loopsUntilValidLocation() {
        input.set("10", "5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue((output.read()).contains("Please choose a number from 1 to 9"));
    }

    @Test
    public void updatesBoardDisplay() {
        input.set("2", "4", "3", "5", "1");
        gameplay.start();
        assertTrue((output.read()).contains(board()));
    }

    @Test
    public void playsADraw() {
        input.set("1", "2", "3", "4", "6", "7", "8", "9", "5");
        gameplay.start();
        assertTrue(output.read().contains(drawBoard()));
        assertTrue(output.read().contains("It's a draw!"));
    }

    @Test
    public void returnsWinner() {
        input.set("5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue(output.read().contains("X wins!"));
    }

    @Test
    public void cannotChooseTakenLocation() {
        input.set("1", "4", "2", "5", "2", "3");
        gameplay.start();
        assertTrue(output.read().contains("Already taken"));
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

    private String drawBoard() {
        return "-------------" + "\n" +
                "| X | 0 | X |" + "\n" +
                "-------------" + "\n" +
                "| 0 | X | X |" + "\n" +
                "-------------" + "\n" +
                "| 0 | X | 0 |" + "\n" +
                "-------------";
    }
}
