package ttt;

import org.junit.Test;
import ttt.game.GameConstructor;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.PlayerFactory;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class GameConstructorTest {

    private PlayerFactory factory = new PlayerFactory(new PlayerFake(Marks.X), new PlayerFake(Marks.O));

    @Test
    public void createsAHumanVHumanGameWith3x3Board() {
        List<Integer> choices = Arrays.asList(1, 3);
        GameEngine game = GameConstructor.create(choices, factory);
        assertTrue(game.getClass().equals(GameEngine.class));
        assertTrue(game.showBoard().size() == 9);
    }

    @Test
    public void createsAHumanVHumanGameWith4x4Board() {
        List<Integer> choices = Arrays.asList(1, 4);
        GameEngine game = GameConstructor.create(choices, factory);
        assertTrue(game.showBoard().size() == 16);
    }
}
