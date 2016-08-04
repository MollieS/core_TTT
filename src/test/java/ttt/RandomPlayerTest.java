package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.FakeRandomizer;
import ttt.players.RandomPlayer;

import static org.junit.Assert.assertEquals;

public class RandomPlayerTest {

    private Board board = new Board(3);
    private RandomPlayer computer;

    @Before
    public void setUp() {
        this.computer = new RandomPlayer(new FakeRandomizer(), Marks.X);
    }

    @Test
    public void returnsARandomLocation() {
        assertEquals(1, computer.getLocation(board));
    }

    @Test
    public void hasMark() {
        assertEquals(computer.getMark(), Marks.X);
    }

    @Test
    public void knowsItsClass() {
        assertEquals(RandomPlayer.class, computer.playerType());
    }
}
