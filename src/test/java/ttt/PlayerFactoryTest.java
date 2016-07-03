package ttt;

import org.junit.Test;
import ttt.game.Marks;
import ttt.players.PlayerFactory;
import ttt.players.*;

import static junit.framework.TestCase.assertTrue;

public class PlayerFactoryTest {

    private Marks X = Marks.X;
    private Marks O = Marks.O;

    @Test
    public void createsAHumanvHumanGameWhereXGoesFirst() {
        Player player = getPlayer(1, 0);
        assertTrue(player.getClass().equals(HumanPlayer.class));
        assertTrue(player.getMark().equals(X));
    }

    @Test
    public void createsARandomComputerWhereHumanGoesFirst() {
        Player player = getPlayer(2, 1);
        assertTrue(player.playerType().equals(RandomPlayer.class));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsARandomComputerWhereComputerGoesFirst() {
        Player player = getPlayer(3, 0);
        assertTrue(player.playerType().equals(RandomPlayer.class));
        assertTrue(player.getMark().equals(X));
    }

    @Test
    public void createsAPerfectPlayer() {
        Player player = getPlayer(4, 1);
        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsAPerfectPlayerThatGoesFirst() {
        Player player = getPlayer(5, 0);
        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player.getMark().equals(X));
    }

    @Test
    public void createsPerfectPlayerVPerfectPlayerGame() {
        Player player = getPlayer(6, 0);
        Player player2 = getPlayer(6, 1);
        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player2.playerType().equals(PerfectPlayer.class));
    }

    @Test
    public void createsPerfectPlayerVRandomPlayerGame() {
        Player player = getPlayer(7, 0);
        Player player2 = getPlayer(7, 1);
        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player2.playerType().equals(RandomPlayer.class));
    }

    @Test
    public void createsComputerPlayerVRandomPlayerGame() {
        Player player = getPlayer(8, 0);
        Player player2 = getPlayer(8, 1);
        assertTrue(player2.playerType().equals(PerfectPlayer.class));
        assertTrue(player.playerType().equals(RandomPlayer.class));
    }

    @Test
    public void createsRandomPlayerVRandomPlayerGame() {
        Player player = getPlayer(9, 0);
        Player player2 = getPlayer(9, 1);
        assertTrue(player2.playerType().equals(RandomPlayer.class));
        assertTrue(player.playerType().equals(RandomPlayer.class));
    }

    private Player getPlayer(int type, int player) {
        return PlayerFactory.create(type, 3).get(player);
    }
}
