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
        assertEquals(4, computerLocation());
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
        assertEquals(2, computerLocation());
    }

    @Test
    public void blocksAWin() {
        game.play(0);
        game.play(4);
        game.play(8);
        game.play(3);
        assertEquals(5, computerLocation());
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
        assertEquals(8, computerLocation());
    }

    @Test
    public void columnWin() {
        game.play(0);
        game.play(2);
        game.play(3);
        game.play(5);
        assertEquals(6, computerLocation());
    }

    @Test
    public void diagonalBlock() {
        game.play(0);
        game.play(2);
        game.play(4);
        assertEquals(8, computerLocation());
    }

    @Test
    public void goesForCentreIfCornerTaken() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        assertEquals(4, computerLocation());
    }

    @Test
    public void doesNotGoForCentreTwice() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        game.play((computerLocation()));
        game.play(2);
        assertEquals(1, computerLocation());
    }

    private int computerLocation() {
        return perfectPlayer.getLocation(input, game);
    }

    @Test
    public void playsADrawWhenSecond() {
        perfectPlayer = new PerfectPlayer("X");
        Player opponent = new HumanPlayer("O");
        board = new Board();
        game = new GameEngine(opponent, perfectPlayer, board);
        game.play(0);
        int cpuChoice = computerLocation();
        assertEquals(4, cpuChoice);
        game.play(cpuChoice);
        game.play(8);
        cpuChoice = computerLocation();
        assertEquals(1, cpuChoice);
        game.play(cpuChoice);
        game.play(7);
        cpuChoice = computerLocation();
        assertEquals(6, cpuChoice);
        game.play(cpuChoice);
        game.play(2);
        cpuChoice = computerLocation();
        assertEquals(5, cpuChoice);
        game.play(cpuChoice);
        game.play(3);
    }

    @Test
    public void winsIfFirst() {
        int cpuChoice = computerLocation();
        assertEquals(0, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 4);
        cpuChoice = computerLocation();
        assertEquals(1, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 2);
        cpuChoice = computerLocation();
        assertEquals(6, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 2);
        cpuChoice = computerLocation();
        assertEquals(3, cpuChoice);
        board.placeMark("X", cpuChoice);
        board.placeMark("O", 3);
    }
}
