package ttt;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.game.GameFactory;
import ttt.players.HumanPlayer;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {

    @Test
    public void createsAHumanVHumanGameWith3x3Board() {
        GameEngine testGame = new GameEngine(new HumanPlayer(Marks.X, new InputFake()), new HumanPlayer(Marks.O, new InputFake()), new Board(3));
        List<Integer> choices = Arrays.asList(1, 1);
        GameEngine game = GameFactory.create(choices);
        assertTrue(game.getClass().equals(testGame.getClass()));
        assertTrue(game.showBoard().size() == 9);
    }

    @Test
    public void createsAHumanVHumanGameWith4x4Board() {
        List<Integer> choices = Arrays.asList(1, 2);
        GameEngine game = GameFactory.create(choices);
        assertTrue(game.showBoard().size() == 16);
    }
}
