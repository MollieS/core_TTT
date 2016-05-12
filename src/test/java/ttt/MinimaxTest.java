package ttt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {
    private Board fillBoard(String...moves) {
        Board board = new Board();
        for (int i = 0; i < moves.length; i++) {
            board.placeMark(moves[i], i);
        }
        return board;
    }

    @Test
    public void returnsTheOnlyMovePossible() {
        Board board = fillBoard("X", "X", "O", "O", "O", "X", "X", "O", " ");
        Minimax minimax = new Minimax("X", "O", board);
        assertEquals(8, minimax.bestMove());
    }

    @Test
    public void returnsTheCenterMoveIfItIsTheLastCell() {
        Board board = fillBoard("X", "O", "X", "O", " ", "X", "X", "O", "O");
        Minimax minimax = new Minimax("X", "O", board);
        assertEquals(4, minimax.bestMove());
    }

    @Test
    public void returnsTheWinningMove() {
        Board board = fillBoard("X", "O", "X", "O", "X", "O", "O", " ", " ");
        Minimax minimax = new Minimax("X", "O", board);
        assertEquals(8, minimax.bestMove());
    }

    @Test
    public void returnsTheWinningMoveOverBlockingMove() {
        Board board = fillBoard("X", "O", "X", "O", "X", "O", " ", " ", "O");
        Minimax minimax = new Minimax("X", "O", board);
        assertEquals(6, minimax.bestMove());
    }

    @Test
    public void takesCornerIfCentreIsTaken() {
        Board board = new Board();
        board.placeMark("X", 0);
        Minimax minimax = new Minimax("O", "X", board);
        assertEquals(4, minimax.bestMove());
    }

    @Test
    public void goesForWin() {
        Board board = fillBoard("X", " ", "X", " ", "O", " ", " ", " ", "O");
        Minimax minimax = new Minimax("X", "O", board);
        assertEquals(1, minimax.bestMove());
    }
}
