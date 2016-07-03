package ttt;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.HumanPlayer;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Test
    public void hasAMark() {
        Player player = new HumanPlayer(Marks.X, new InputFake(), 3);
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void returnsALocation() throws Exception {
        InputFake input = new InputFake();
        input.set("1");
        Player player = new HumanPlayer(Marks.X, input, 3);
        Board board = new Board(3);
        assertEquals(Integer.valueOf(0), player.getLocation(board));
    }
}
