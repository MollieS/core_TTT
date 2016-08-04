package ttt;

import org.junit.Test;
import ttt.game.GameConstructor;
import ttt.game.GameEngine;

import static junit.framework.TestCase.assertTrue;

public class GameConstructorTest {

    @Test
    public void createsAPerfectVPerfectGameWith3x3Board() {
        GameEngine game = GameConstructor.create(PlayerType.PERFECT, PlayerType.PERFECT, 3);
        assertTrue(game.getClass().equals(GameEngine.class));
        assertTrue(game.showBoard().size() == 9);
    }

    @Test
    public void createsAPerfectVPerfectGameWith4x4Board() {
        GameEngine game = GameConstructor.create(PlayerType.PERFECT, PlayerType.PERFECT, 4);
        assertTrue(game.showBoard().size() == 16);
    }
}
