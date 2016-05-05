import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GamePlayTest {

    private GamePlay gameplay;
    private DisplayFake display;
    private InputFake input;

    @Before
    public void setUp() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("0");
        Game game = new Game(player1, player2, board);
        this.input = new InputFake();
        this.display = new DisplayFake();
        this.gameplay = new GamePlay(game, input, display);
    }

    @Test
    public void promptsUserForLocation() {
        input.set("5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue(displayContains("choose a location"));
    }

    @Test
    public void onlyAcceptsNumbers() {
        input.set("Hello", "5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue(displayContains("Numbers only"));
    }

    @Test
    public void loopsUntilValidLocation() {
        input.set("10", "5", "1", "4", "2", "6", "7", "9");
        gameplay.start();
        assertTrue(displayContains("Please choose a location from 1 to 9"));
    }

    private boolean displayContains(String s) {
        return display.read().contains(s);
    }

    @Test
    public void playsADraw() {
        input.set("1", "2", "3", "4", "6", "7", "8", "9", "5");
        gameplay.start();
        assertTrue(displayContains(drawBoard()));
        assertTrue(displayContains("It's a draw!"));
    }

    @Test
    public void returnsWinner() {
        input.set("5", "1", "4", "2", "6");
        gameplay.start();
        assertTrue(displayContains("X wins!"));
    }

    @Test
    public void cannotChooseTakenLocation() {
        input.set("1", "4", "2", "5", "2", "3");
        gameplay.start();
        assertTrue(displayContains("Already taken"));
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
