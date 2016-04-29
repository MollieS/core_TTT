import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        Board board = new Board();
        this.game = new Game(player1, player2, board);
    }

    @Test
    public void playsAMove() {
        game.play(0);
        assertEquals("X", game.board(0));
    }

    @Test
    public void switchesTurns() {
        game.play(0);
        game.play(1);
        assertEquals("O", game.board(1));
    }

    @Test
    public void horizontalWinForX() {
        horizontalWinForPlayerOne();
        assertTrue(game.won());
    }

    @Test
    public void diagonalWinForO() {
        diagonalWinForPlayer2();
        assertTrue(game.won());
    }

    @Test
    public void draw() {
        drawGame();
        assertTrue(game.draw());
    }

    @Test
    public void gameNotOverWhenStarts() {
        assertFalse(game.over());
    }

    @Test
    public void gameOverIfWon() {
        horizontalWinForPlayerOne();
        assertTrue(game.over());
    }

    @Test
    public void gameOverIfDraw() {
        drawGame();
        assertTrue(game.over());
    }

    @Test
    public void knowsWinnerIfPlayerOne() {
        horizontalWinForPlayerOne();
        assertEquals(player1, game.winner());
    }

    @Test
    public void knowsWinnerIfPlayerTwo() {
        diagonalWinForPlayer2();
        assertEquals(player2, game.winner());
    }

    @Test
    public void returnsNullWhenNoWinner() {
        drawGame();
        assertEquals(null, game.winner());
    }

    private void horizontalWinForPlayerOne() {
        game.play(0);
        game.play(3);
        game.play(1);
        game.play(4);
        game.play(2);
    }

    private void diagonalWinForPlayer2() {
        game.play(3);
        game.play(0);
        game.play(5);
        game.play(4);
        game.play(7);
        game.play(8);
    }

    private void drawGame() {
        game.play(0);
        game.play(1);
        game.play(2);
        game.play(3);
        game.play(5);
        game.play(6);
        game.play(7);
        game.play(8);
        game.play(4);
    }
}
