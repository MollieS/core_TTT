package test;

import main.Board;
import main.GameEngine;
import main.HumanPlayer;
import main.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Test
    public void hasASymbol() {
        Player player = new HumanPlayer("X");
        assertEquals("X", player.getMark());
    }

    @Test
    public void getsALocation() {
        InputFake input = new InputFake();
        Player player = new HumanPlayer("X");
        input.set("1");
        Board board = new Board();
        GameEngine game = new GameEngine(player, player, board);
        assertEquals(0, player.getLocation(input, game));
    }
}
