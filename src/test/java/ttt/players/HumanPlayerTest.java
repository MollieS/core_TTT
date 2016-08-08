package ttt.players;

import org.junit.Before;
import org.junit.Test;
import ttt.InputFake;
import ttt.game.Board;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private InputFake input;
    private HumanPlayer player;

    @Before
    public void setUp() {
        input = new InputFake();
        player = new HumanPlayer(Marks.X, input);
    }

    @Test
    public void hasAMark() {
        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void returnsALocation() throws Exception {
        Board board = new Board(3);
        input.set("1");
        assertEquals(0, player.getLocation(board));
    }

}