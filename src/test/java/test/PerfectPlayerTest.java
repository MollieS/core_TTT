package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PerfectPlayerTest {

    private Player perfectPlayer;
    private Input input;
    private GameEngine game;

    @Before
    public void setUp() {
        this.perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        Board board = new Board();
        this.game = new GameEngine(perfectPlayer, opponent, board);
        this.input = new InputFake();
    }

   /*
    @Test
    public void returnsALocation() {
        assertEquals(6, perfectPlayer.getLocation(input, game));
        assertTrue(perfectPlayer.getLocation(input, game) != 10);
    }

    @Test
    public void choosesBestLocationForEmptyBoard() {
        assertEquals(6, perfectPlayer.getLocation(input, game));
    }
    */

    @Test
    public void choosesOnlyFreeSpaceOnFullBoard() {
        game.play(0);
        game.play(1);
        game.play(2);
        game.play(3);
        game.play(5);
        game.play(6);
        game.play(7);
        game.play(8);
        assertEquals(4, perfectPlayer.getLocation(input, game));
        assertTrue(perfectPlayer.getLocation(input, game) == 4);
    }
}
