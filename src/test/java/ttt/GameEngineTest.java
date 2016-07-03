package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.players.HumanPlayer;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameEngineTest {

    private GameEngine gameEngine;
    private Player player1;
    private Player player2;
    private Board board;

    @Before
    public void setUp() throws Exception {
        this.player1 = new HumanPlayer(Marks.X, new InputFake(), 3);
        this.player2 = new HumanPlayer(Marks.O, new InputFake(), 3);
        this.board = new Board(3);
        this.gameEngine = new GameEngine(player1, player2, board);
    }

    @Test
    public void updatesAvailableLocations() {
        gameEngine.play(0);
        board = gameEngine.showBoard();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), board.availableMoves());
    }

    @Test
    public void playsAMove() {
        gameEngine.play(0);
        assertEquals(Marks.X, gameEngine.board(0));
    }

    @Test
    public void switchesTurns() {
        gameEngine.play(0);
        gameEngine.play(1);
        assertEquals(Marks.O, gameEngine.board(1));
    }

    @Test
    public void switchesTurnBack() {
        gameEngine.play(0);
        gameEngine.play(4);
        gameEngine.play(7);
        assertEquals(Marks.X, gameEngine.board(7));
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
    public void knowsWhenAGameIsDrawn() {
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
    public void gameOverIfDrawn() {
        drawGame();
        assertTrue(gameEngine.isOver());
    }

    @Test
    public void gameIsNotDrawnIfWon() {
        fullBoardWin();
        assertFalse(gameEngine.isDraw());
    }

    @Test
    public void knowsWinnerIfPlayerOne() {
        horizontalWinForPlayerOne();
        assertEquals(player1.getMark(), gameEngine.winningMark());
    }

    @Test
    public void knowsWinnerIfPlayerTwo() {
        diagonalWinForPlayer2();
        assertEquals(player2.getMark(), gameEngine.winningMark());
    }

    @Test
    public void returnsNullWhenThereIsNoWinner() {
        drawGame();
        assertEquals(Marks.NULL, gameEngine.winningMark());
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
