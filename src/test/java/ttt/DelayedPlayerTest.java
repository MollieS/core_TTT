package ttt;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.DelayedPlayer;
import ttt.players.PerfectPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

import static org.junit.Assert.assertTrue;

public class DelayedPlayerTest {

    @Test
    public void delaysRandomPlayerByASecond() throws InterruptedException {
        DelayedPlayer player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
        assertTrue(player.getDelay() == 1000);
    }

    @Test
    public void doesNotDelayPerfectPlayerOnEmptyBoard() throws Exception {
        DelayedPlayer player = new DelayedPlayer(new PerfectPlayer(Marks.X));
        assertTrue(player.getDelay() == 0);
    }

    @Test
    public void delaysPerfectPlayerOnSmallerBoard() throws Exception {
        Board board = new Board(3);
        DelayedPlayer player = new DelayedPlayer(new PerfectPlayer(Marks.X));
        player.getLocation(board);
        assertTrue(player.getDelay() == 1000);
    }
}
