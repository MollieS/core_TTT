package ttt;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {

    @Test
    public void createsAHumanVHumanGame() {
        GameEngine testGame = new GameEngine(new HumanPlayer(Marks.X), new HumanPlayer(Marks.O), new Board(3));
        GameEngine game = GameFactory.create(1);
        assertTrue(game.getClass().equals(testGame.getClass()));
    }
}
