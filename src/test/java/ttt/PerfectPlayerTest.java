package ttt;

import org.junit.Before;

import org.junit.Test;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.players.HumanPlayer;
import ttt.players.PerfectPlayer;

import static org.junit.Assert.assertEquals;

public class PerfectPlayerTest {

    private PerfectPlayer perfectPlayer;
    private GameEngine game;
    private Board board;
    private Marks X = Marks.X;
    private Marks O = Marks.O;

    @Before
    public void setUp() {
        this.perfectPlayer = new PerfectPlayer(X);
        Player opponent = new HumanPlayer(O, new InputFake());
        this.board = new Board(3, new Marks[0]);
        this.game = new GameEngine(perfectPlayer, opponent, board);
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
        assertEquals(4, computerLocation(game.showBoard()));
    }

    @Test
    public void goesForWin() {
        board = board.placeMark(X, 0);
        board = board.placeMark(O, 3);
        board = board.placeMark(X, 1);
        board = board.placeMark(O, 4);
        assertEquals(2, computerLocation(board));
    }

    @Test
    public void blocksAWin() {
        game.play(0);
        game.play(4);
        game.play(8);
        game.play(3);
        assertEquals(5, computerLocation(game.showBoard()));
    }

    @Test
    public void diagonalWin() {
        game.play(0);
        game.play(2);
        game.play(4);
        game.play(1);
        assertEquals(8, computerLocation(game.showBoard()));
    }

    @Test
    public void columnWin() {
        game.play(0);
        game.play(2);
        game.play(3);
        game.play(5);
        assertEquals(6, computerLocation(game.showBoard()));
    }

    @Test
    public void diagonalBlock() {
        game.play(0);
        game.play(2);
        game.play(4);
        assertEquals(8, computerLocation(game.showBoard()));
    }

    @Test
    public void goesForCentreIfCornerTaken() {
        setUpGame();
        game.play(0);
        assertEquals(4, computerLocation(game.showBoard()));
    }

    @Test
    public void doesNotGoForCentreTwice() {
        setUpGame();
        game.play(0);
        game.play((computerLocation(game.showBoard())));
        game.play(2);
        assertEquals(1, computerLocation(game.showBoard()));
    }

    @Test
    public void playsADrawWhenSecond() {
        setUpGame();
        game.play(0);
        int computerLocation = computerLocation(game.showBoard());
        assertEquals(4, computerLocation);
        game.play(computerLocation);
        game.play(8);
        computerLocation = computerLocation(game.showBoard());
        assertEquals(1, computerLocation);
        game.play(computerLocation);
        game.play(7);
        computerLocation = computerLocation(game.showBoard());
        assertEquals(6, computerLocation);
        game.play(computerLocation);
        game.play(2);
        computerLocation = computerLocation(game.showBoard());
        assertEquals(5, computerLocation);
        game.play(computerLocation);
        game.play(3);
    }

    @Test
    public void winsIfFirst() {
        int cpuChoice = computerLocation(board);
        assertEquals(0, cpuChoice);
        board = board.placeMark(X, cpuChoice);
        board = board.placeMark(O, 4);
        cpuChoice = computerLocation(board);
        assertEquals(1, cpuChoice);
        board = board.placeMark(X, cpuChoice);
        board = board.placeMark(O, 2);
        cpuChoice = computerLocation(board);
        assertEquals(6, cpuChoice);
        board = board.placeMark(X, cpuChoice);
        board = board.placeMark(O, 2);
        cpuChoice = computerLocation(board);
        assertEquals(3, cpuChoice);
        board = board.placeMark(X, cpuChoice);
        board = board.placeMark(O, 3);
    }

    private int computerLocation(Board board) {
        String choice = perfectPlayer.getLocation(board);
        return Integer.parseInt(choice);
    }


    private void setUpGame() {
        perfectPlayer = new PerfectPlayer(X);
        Player opponent = new HumanPlayer(O, new InputFake());
        board = new Board(3, new Marks[0]);
        game = new GameEngine(opponent, perfectPlayer, board);
    }


}
