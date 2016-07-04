package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Marks;
import ttt.players.DelayedPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelayedPlayerTest {

    private DelayedPlayer player;

    @Before
    public void setUp() {
        this.player = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
    }

    @Test
    public void onlyDelaysIfDurationShorterThanHalfASecond() throws InterruptedException {
        long start = System.currentTimeMillis();
        player.delayResponse(2, 600);
        long end = System.currentTimeMillis();
        assertTrue(end - start < 1000);
    }

    @Test
    public void delaysIfLessThanHalfASecond() throws Exception {
        long start = System.currentTimeMillis();
        player.delayResponse(2, 400);
        long end = System.currentTimeMillis();
        assertTrue(end - start > 900);
    }

    @Test
    public void knowsTheMarkOfThePlayer() {
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void knowsTheTypeOfThePlayer() {
        assertEquals(RandomPlayer.class, player.playerType());
    }
}
