package ttt;

import org.junit.Test;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.PlayerFactory;
import ttt.players.RandomPlayer;

import static junit.framework.TestCase.assertTrue;

public class PlayerFactoryTest {

    private Marks X = Marks.X;
    private Marks O = Marks.O;

    @Test
    public void createsAHumanvHumanGameWhereXGoesFirst() {
        Player player = getPlayer(1, 0);
        Player player2 = getPlayer(1, 1);

        assertTrue(player.playerType().equals(PlayerFake.class));
        assertTrue(player2.playerType().equals(PlayerFake.class));

        assertTrue(player.getMark().equals(X));
        assertTrue(player2.getMark().equals(O));
    }

    @Test
    public void createsARandomComputerWhereHumanGoesFirst() {
        Player randomPlayer = getPlayer(2, 1);
        Player humanPlayer = getPlayer(2, 0);

        assertTrue(randomPlayer.playerType().equals(RandomPlayer.class));
        assertTrue(humanPlayer.playerType().equals(PlayerFake.class));

        assertTrue(randomPlayer.getMark().equals(O));
        assertTrue(humanPlayer.getMark().equals(X));
    }

    @Test
    public void createsARandomComputerWhereComputerGoesFirst() {
        Player randomPlayer = getPlayer(3, 0);
        Player humanPlayer = getPlayer(3, 1);

        assertTrue(randomPlayer.playerType().equals(RandomPlayer.class));
        assertTrue(humanPlayer.playerType().equals(PlayerFake.class));

        assertTrue(randomPlayer.getMark().equals(X));
        assertTrue(humanPlayer.getMark().equals(O));
    }

    @Test
    public void createsAPerfectPlayerThatGoesSecond() {
        Player perfectPlayer = getPlayer(5, 1);
        Player humanPlayer = getPlayer(5, 0);

        assertTrue(perfectPlayer.playerType().equals(PerfectPlayer.class));
        assertTrue(humanPlayer.playerType().equals(PlayerFake.class));

        assertTrue(perfectPlayer.getMark().equals(O));
        assertTrue(humanPlayer.getMark().equals(X));
    }

    @Test
    public void createsAPerfectPlayerThatGoesFirst() {
        Player perfectPlayer = getPlayer(6, 0);
        Player humanPlayer = getPlayer(6, 1);

        assertTrue(perfectPlayer.playerType().equals(PerfectPlayer.class));
        assertTrue(humanPlayer.playerType().equals(PlayerFake.class));

        assertTrue(perfectPlayer.getMark().equals(X));
        assertTrue(humanPlayer.getMark().equals(O));
    }

    @Test
    public void createsPerfectPlayerVPerfectPlayerGame() {
        Player player = getPlayer(7, 0);
        Player player2 = getPlayer(7, 1);

        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player2.playerType().equals(PerfectPlayer.class));
    }

    @Test
    public void createsPerfectPlayerVRandomPlayerGame() {
        Player player = getPlayer(8, 0);
        Player player2 = getPlayer(8, 1);

        assertTrue(player.playerType().equals(PerfectPlayer.class));
        assertTrue(player2.playerType().equals(RandomPlayer.class));
    }

    @Test
    public void createsRandomPlayerVPerfectPlayerGame() {
        Player player = getPlayer(9, 0);
        Player player2 = getPlayer(9, 1);

        assertTrue(player2.playerType().equals(PerfectPlayer.class));
        assertTrue(player.playerType().equals(RandomPlayer.class));
    }

    @Test
    public void createsRandomPlayerVRandomPlayerGame() {
        Player player = getPlayer(4, 0);
        Player player2 = getPlayer(4, 1);

        assertTrue(player2.playerType().equals(RandomPlayer.class));
        assertTrue(player.playerType().equals(RandomPlayer.class));
    }

    private Player getPlayer(int type, int player) {
        PlayerFactory factory = new PlayerFactory(new PlayerFake(X), new PlayerFake(O));
        return factory.create(type).get(player);
    }
}
