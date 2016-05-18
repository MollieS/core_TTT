package ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectPlayerTest {

    private PerfectPlayer perfectPlayer;
    private Input input;
    private GameEngine game;
    private Board board;
    private Marks X = Marks.X;
    private Marks O = Marks.O;

    @Before
    public void setUp() {
        this.perfectPlayer = new PerfectPlayer(X);
        Player opponent = new HumanPlayer(O);
        this.board = new Board(3);
        this.game = new GameEngine(perfectPlayer, opponent, board);
        this.input = new InputFake();
    }

    @Test
    public void knowsOpponentMark() {
        assertEquals(O, perfectPlayer.opponentMark());
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
        board.placeMark(X, 0);
        board.placeMark(O, 3);
        board.placeMark(X, 1);
        board.placeMark(O, 4);
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
        setUpGame();
        game.play(0);
        assertEquals(4, computerLocation());
    }

    @Test
    public void doesNotGoForCentreTwice() {
        setUpGame();
        game.play(0);
        game.play((computerLocation()));
        game.play(2);
        assertEquals(1, computerLocation());
    }

    private int computerLocation() {
        String choice = perfectPlayer.getLocation(input, board);
        return Integer.parseInt(choice);
    }

    @Test
    public void playsADrawWhenSecond() {
        setUpGame();
        game.play(0);
        int computerLocation = computerLocation();
        assertEquals(4, computerLocation);
        game.play(computerLocation);
        game.play(8);
        computerLocation = computerLocation();
        assertEquals(1, computerLocation);
        game.play(computerLocation);
        game.play(7);
        computerLocation = computerLocation();
        assertEquals(6, computerLocation);
        game.play(computerLocation);
        game.play(2);
        computerLocation = computerLocation();
        assertEquals(5, computerLocation);
        game.play(computerLocation);
        game.play(3);
    }

    @Test
    public void winsIfFirst() {
        int cpuChoice = computerLocation();
        assertEquals(0, cpuChoice);
        board.placeMark(X, cpuChoice);
        board.placeMark(O, 4);
        cpuChoice = computerLocation();
        assertEquals(1, cpuChoice);
        board.placeMark(X, cpuChoice);
        board.placeMark(O, 2);
        cpuChoice = computerLocation();
        assertEquals(6, cpuChoice);
        board.placeMark(X, cpuChoice);
        board.placeMark(O, 2);
        cpuChoice = computerLocation();
        assertEquals(3, cpuChoice);
        board.placeMark(X, cpuChoice);
        board.placeMark(O, 3);
    }

    private void setUpGame() {
        perfectPlayer = new PerfectPlayer(X);
        Player opponent = new HumanPlayer(O);
        board = new Board(3);
        game = new GameEngine(opponent, perfectPlayer, board);
    }


}
