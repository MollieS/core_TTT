package ttt;

import org.junit.Before;
import org.junit.Test;

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
        menu.show();
        assertTrue(display.read().contains("Computer"));
    }

    @Test
    public void createsAHumanOpponent() {
        assertTrue(menu.createPlayers("1").get(1).getClass() == HumanPlayer.class);
    }

    @Test
    public void createsAComputerOpponent() {
        assertTrue(menu.createPlayers("4").get(0).getClass() == ComputerPlayer.class);
    }

    @Test
    public void createsAGame() {
        input.set("2");
        assertTrue(menu.createGame().getClass() == GameEngine.class);
    }

    @Test
    public void loopsForValidInput() {
        input.set("hello", "2");
        menu.createGame();
        assertTrue(display.read().contains("Please choose a valid option"));
    }
}
