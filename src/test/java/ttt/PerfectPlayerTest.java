package ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectPlayerTest {

    private PerfectPlayer perfectPlayer;
    private Input input;
    private GameEngine game;
    private Board board;

    @Before
    public void setUp() {
        this.perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        this.board = new Board();
        this.game = new GameEngine(perfectPlayer, opponent, board);
        this.input = new InputFake();
    }

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
    }

    @Test
    public void goesForWin() {
        board.placeMark("X", 0);
        board.placeMark("O", 3);
        board.placeMark("X", 1);
        board.placeMark("O", 4);
        /*
        game.play(0);
        game.play(3);
        game.play(1);
        game.play(4);
        */
        assertEquals(2, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void blocksAWin() {
        game.play(0);
        game.play(4);
        game.play(8);
        game.play(3);
        assertEquals(5, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void blocksAWinWhenItGoesSecond() {
        Player player1 = new HumanPlayer("X");
        Player player2 = new PerfectPlayer("O");
        Board board = new Board();
        GameEngine game = new GameEngine(player1, player2, board);
        game.play(0);
        game.play(6);
        game.play(1);
        assertEquals(2, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void diagonalWin() {
        game.play(0);
        game.play(2);
        game.play(4);
        game.play(1);
        assertEquals(8, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void columnWin() {
        game.play(0);
        game.play(2);
        game.play(3);
        game.play(5);
        assertEquals(6, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void diagonalBlock() {
        game.play(0);
        game.play(2);
        game.play(4);
        assertEquals(8, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void goesForCentreIfCornerTaken() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        assertEquals(4, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void doesNotGoForCentreTwice() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        game.play(perfectPlayer.getLocation(input, game));
        game.play(2);
        assertEquals(1, perfectPlayer.getLocation(input, game));
    }

    @Test
    public void resetsBestMove() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        int cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(4, cpuChoice);
        game.play(cpuChoice);
        game.play(8);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(1, cpuChoice);
        game.play(cpuChoice);
        game.play(7);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(6, cpuChoice);
        game.play(cpuChoice);
        game.play(2);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(5, cpuChoice);
        game.play(cpuChoice);
        game.play(3);
    }

    @Test
    public void pt2() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        board.placeMark("O", 0);
        int cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(4, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 8);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(1, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 7);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(6, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 2);
        cpuChoice = perfectPlayer.getLocation(input, game);
        assertEquals(5, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 3);
    }
}
