package ttt;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.HumanPlayer;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Test
    public void hasAMark() {
        Player player = new HumanPlayer(Marks.X, new InputFake());
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void returnsALocation() {
        InputFake input = new InputFake();
        input.set("1");
        Player player = new HumanPlayer(Marks.X, input);
        Board board = new Board(3, new Marks[0]);
        assertEquals("0", player.getLocation(board));
    }
}
