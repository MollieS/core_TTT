package ttt;

import org.junit.Test;
import ttt.game.GameEngine;
import ttt.game.GameConstructor;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class GameConstructorTest {

    @Test
    public void createsAHumanVHumanGameWith3x3Board() {
        List<Integer> choices = Arrays.asList(1, 1);
        GameEngine game = GameConstructor.create(choices);
        assertTrue(game.getClass().equals(GameEngine.class));
        assertTrue(game.showBoard().size() == 9);
    }

    @Test
    public void createsAHumanVHumanGameWith4x4Board() {
        List<Integer> choices = Arrays.asList(1, 2);
        GameEngine game = GameConstructor.create(choices);
        assertTrue(game.showBoard().size() == 16);
    }
}
