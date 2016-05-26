package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.GameEngine;
import ttt.game.GameMenu;

import static junit.framework.TestCase.assertTrue;

public class MenuTest {

    private DisplayFake display = new DisplayFake();
    private InputFake input = new InputFake();
    private GameMenu menu;

    @Before
    public void setUp() {
        this.menu = new GameMenu(input, display);
    }

    @Test
    public void asksWhichGameUserWants() {
        input.set("1", "2");
        menu.createGame();
        assertTrue(display.read().contains("Computer"));
    }

    @Test
    public void asksWhichSizeBoardTheUserWants() {
        input.set("2", "2");
        menu.createGame();
        assertTrue(display.read().contains("3 x 3"));
    }

    @Test
    public void validatesInputForBoard() {
        input.set("2", "43", "2");
        menu.createGame();
        assertTrue(display.read().contains("Please choose a valid option"));
    }

    @Test
    public void createsAGame() {
        input.set("2", "1");
        assertTrue(menu.createGame().getClass() == GameEngine.class);
    }

    @Test
    public void loopsForValidInputForGame() {
        input.set("24", "2", "1");
        menu.createGame();
        assertTrue(display.read().contains("Please choose a valid option"));
    }
}
