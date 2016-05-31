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
        assertTrue(player.getClass().equals(new HumanPlayer(X, new InputFake()).getClass()));
        assertTrue(player.getMark().equals(X));
    }

    private Player getPlayer(int type, int player) {
        return PlayerFactory.create(type).get(player);
    }

    @Test
    public void createsARandomComputerWhereHumanGoesFirst() {
        Player player = getPlayer(2, 1);
        assertTrue(player.getClass().equals(new ComputerPlayer(new RandomLocationGenerator(), O).getClass()));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsARandomComputerWhereComputerGoesFirst() {
        Player player = getPlayer(3, 0);
        assertTrue(player.getClass().equals(new ComputerPlayer(new RandomLocationGenerator(), X).getClass()));
        assertTrue(player.getMark().equals(X));
    }

    @Test
    public void createsAPerfectPlayer() {
        Player player = getPlayer(4, 1);
        assertTrue(player.getClass().equals(new PerfectPlayer(O).getClass()));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsAPerfectPlayerThatGoesFirst() {
        Player player = getPlayer(5, 0);
        assertTrue(player.getClass().equals(new PerfectPlayer(O).getClass()));
        assertTrue(player.getMark().equals(X));
    }
}
