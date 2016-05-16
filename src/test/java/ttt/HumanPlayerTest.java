package ttt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Test
    public void hasAMark() {
        Player player = new HumanPlayer("X");
        assertEquals("X", player.getMark());
    }

    @Test
    public void returnsALocation() {
        InputFake input = new InputFake();
        Player player = new HumanPlayer("X");
        input.set("1");
        Board board = new Board();
        assertEquals("0", player.getLocation(input, board));
    }
}
