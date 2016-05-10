package test;

import main.Board;
import main.GameEngine;
import main.HumanPlayer;
import main.Player;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameEngineTest {

    private GameEngine gameEngine;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        this.player1 = new HumanPlayer("X");
        this.player2 = new HumanPlayer("O");
        Board board = new Board();
        this.gameEngine = new GameEngine(player1, player2, board);
    }

    @Test
    public void playsAMove() {
        gameEngine.play(0);
        assertEquals("X", gameEngine.board(0));
    }

    @Test
    public void switchesTurns() {
        gameEngine.play(0);
        gameEngine.play(1);
        assertEquals("O", gameEngine.board(1));
    }

    @Test
    public void horizontalWinForX() {
        horizontalWinForPlayerOne();
        assertTrue(gameEngine.isWon());
    }

    @Test
    public void diagonalWinForO() {
        diagonalWinForPlayer2();
        assertTrue(gameEngine.isWon());
    }

    @Test
    public void draw() {
        drawGame();
        assertTrue(gameEngine.isDraw());
    }

    @Test
    public void gameNotOverWhenStarts() {
        assertFalse(gameEngine.isOver());
    }

    @Test
    public void gameOverIfWon() {
        horizontalWinForPlayerOne();
        assertTrue(gameEngine.isOver());
    }

    @Test
    public void gameOverIfDraw() {
        drawGame();
        assertTrue(gameEngine.isOver());
    }

    @Test
    public void drawnGame() {
        drawGame();
        assertTrue(gameEngine.isDraw());
    }

    @Test
    public void gameIsNotDrawnIfWon() {
        fullBoardWin();
        assertFalse(gameEngine.isDraw());
    }

    @Test
    public void knowsWinnerIfPlayerOne() {
        horizontalWinForPlayerOne();
        assertEquals(player1, gameEngine.winner());
    }

    @Test
    public void knowsWinnerIfPlayerTwo() {
        diagonalWinForPlayer2();
        assertEquals(player2, gameEngine.winner());
    }

    @Test
    public void returnsNullWhenNoWinner() {
        drawGame();
        assertEquals(null, gameEngine.winner());
    }

    private void horizontalWinForPlayerOne() {
        gameEngine.play(0);
        gameEngine.play(3);
        gameEngine.play(1);
        gameEngine.play(4);
        gameEngine.play(2);
    }

    private void diagonalWinForPlayer2() {
        gameEngine.play(3);
        gameEngine.play(0);
        gameEngine.play(5);
        gameEngine.play(4);
        gameEngine.play(7);
        gameEngine.play(8);
    }

    private void drawGame() {
        gameEngine.play(0);
        gameEngine.play(1);
        gameEngine.play(2);
        gameEngine.play(3);
        gameEngine.play(5);
        gameEngine.play(6);
        gameEngine.play(7);
        gameEngine.play(8);
        gameEngine.play(4);
    }

    private void fullBoardWin() {
        gameEngine.play(0);
        gameEngine.play(3);
        gameEngine.play(1);
        gameEngine.play(4);
        gameEngine.play(5);
        gameEngine.play(6);
        gameEngine.play(7);
        gameEngine.play(8);
        gameEngine.play(2);
    }
}
