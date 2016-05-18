package ttt;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {

    @Test
    public void createsAHumanVHumanGameWith3x3Board() {
        GameEngine testGame = new GameEngine(new HumanPlayer(Marks.X), new HumanPlayer(Marks.O), new Board(3));
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
