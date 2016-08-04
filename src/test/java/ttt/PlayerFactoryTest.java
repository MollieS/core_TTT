package ttt;

import org.junit.Test;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.PlayerFactory;
import ttt.players.RandomPlayer;

import static org.junit.Assert.assertEquals;

public class PlayerFactoryTest {

    @Test
    public void createsARandomPlayer() {
        Player player = PlayerFactory.create(PlayerType.RANDOM, Marks.X);

        assertEquals(RandomPlayer.class, player.playerType());
    }

    @Test
    public void createsAPerfectPlayer() {
        Player player = PlayerFactory.create(PlayerType.PERFECT, Marks.X);

        assertEquals(PerfectPlayer.class, player.playerType());
    }

}
