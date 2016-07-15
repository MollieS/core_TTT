package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.GameEngine;
import ttt.game.GameMenu;
import ttt.game.Marks;

import static junit.framework.TestCase.assertTrue;

public class MenuTest {

    private DisplayFake display = new DisplayFake();
    private InputFake input = new InputFake();
    private GameMenu menu;

    @Before
    public void setUp() {
        this.menu = new GameMenu(input, display, new BoardDisplayFake(), new PlayerFake(Marks.X), new PlayerFake(Marks.O));
    }

    @Test
    public void asksWhichGameUserWants() {
        input.set("1", "3");
        menu.createGame();
        assertTrue(display.read().contains("Random"));
    }

    @Test
    public void asksWhichSizeBoardTheUserWants() {
        input.set("2", "3");
        menu.createGame();
        assertTrue(display.read().contains("3x3"));
    }

    @Test
    public void validatesInputForBoard() {
        input.set("2", "43", "3");
        menu.createGame();
        assertTrue(display.read().contains("Please choose a valid option"));
    }

    @Test
    public void createsAGame() {
        input.set("2", "3");
        assertTrue(menu.createGame().getClass() == GameEngine.class);
    }

    @Test
    public void loopsForValidInputForGame() {
        input.set("24", "2", "3");
        menu.createGame();
        assertTrue(display.read().contains("Please choose a valid option"));
    }

    @Test
    public void canReplayTheGame() {
        input.set("y", "1", "3");
        GameEngine game = menu.askForReplay();
        assertTrue(game.getClass() == GameEngine.class);
    }

    @Test
    public void canNotReplayTheGame() {
        input.set("n");
        GameEngine game = menu.askForReplay();
        assertTrue(game == null);
    }
}
