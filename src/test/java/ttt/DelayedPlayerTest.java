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
    public void delaysIfLessThanHalfASecond() throws Exception {
        DelayedPlayer player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
        long start = System.currentTimeMillis();
        player.delayResponse(2, 400);
        long end = System.currentTimeMillis();
        assertTrue(end - start > 1000);
    }
}
