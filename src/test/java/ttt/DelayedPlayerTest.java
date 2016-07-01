package ttt;

import org.junit.Before;
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
    public void onlyDelaysIfDurationShorterThanHalfASecond() throws InterruptedException {
        DelayedPlayer player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
        long start = System.currentTimeMillis();
        player.delayResponse(2, 600);
        long end = System.currentTimeMillis();
        assertTrue(end - start < 1000);

    }

    @Test
    public void delaysRandomPlayer() throws Exception {
        Board board = new Board(3);
        DelayedPlayer player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
        long start = System.currentTimeMillis();
        player.getLocation(board);
        long end = System.currentTimeMillis();
        assertTrue((end - start) > 1000);
    }

    @Test
    public void doesNotDelayPerfectPlayerIfItTakesLongerThanASecond() throws Exception {
        Board board = new Board(4);
        DelayedPlayer player = new DelayedPlayer(new PerfectPlayer(Marks.X));
        long start = System.currentTimeMillis();
        player.getLocation(board);
        long end = System.currentTimeMillis();
        assertTrue((end - start) > 500);
        assertTrue((end - start) < 2000);
    }
}
