package ttt;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.DelayedPlayer;
import ttt.players.PerfectPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelayedPlayerTest {

    @Test
    public void delaysRandomPlayerByASecond() throws InterruptedException {
        DelayedPlayer player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X), 1000);
        assertTrue(player.getDelay() == 1000);
    }

    @Test
    public void doesNotDelayPerfectPlayerOnEmptyBigBoard() throws Exception {
        DelayedPlayer player = new DelayedPlayer(new PerfectPlayer(Marks.X), 0);
        player.getLocation(new Board(4));
        assertTrue(player.getDelay() == 0);
    }

    @Test
    public void delaysPlayerOnEmptySmallBoard() throws Exception {
        Board board = new Board(3);
        DelayedPlayer player = new DelayedPlayer(new PerfectPlayer(Marks.X), 0);
        player.getLocation(board);
        assertTrue(player.getDelay() == 1000);
    }

    @Test
    public void knowsTheMarkOfThePlayer() {
        Player player = new DelayedPlayer(new PerfectPlayer(Marks.X), 0);
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void knowsTheTypeOfThePlayer() {
        Player player = new DelayedPlayer(new PerfectPlayer(Marks.X), 0);
        assertEquals(PerfectPlayer.class, player.playerType());
    }
}
