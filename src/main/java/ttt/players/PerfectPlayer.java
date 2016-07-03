package ttt.players;

import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

import java.util.*;

public class PerfectPlayer implements Player {

    private Marks mark;
    private Marks opponent;
    private HashMap<Integer, Integer> scores = new HashMap<>();

    public PerfectPlayer(Marks mark) {
        this.mark = mark;
        this.opponent = mark.equals(Marks.X) ? Marks.O : Marks.X;
    }

    public Integer getLocation(Board board) {
        resetMoveSelection();
        return getBestMove(board);
    }

    public Class playerType() {
        return getClass();
    }

    public Marks getMark() {
        return mark;
    }

    private int negamax(Board board, int depth, int colour, int alpha, int beta) {
        if (board.isFinished() || depth == 8) { return score(board, depth) * colour; }
        int bestValue = -999;
        for (int move : board.availableMoves()) {
            Board markedBoard = makeMove(board, colour, move);
            int value = -negamax(markedBoard, depth + 1, -colour, -beta, -alpha);
            bestValue = Math.max(value, bestValue);
            if (depth == 0 && bestValue > alpha) { scores.put(move, bestValue); }
            alpha = Math.max(alpha, bestValue);
            if (alpha >= beta) { break; }
        }
        return bestValue;
    }

    private Board makeMove(Board board, int colour, int move) {
        if (colour == 1) {
            board = board.placeMark(mark, move);
        } else {
            board = board.placeMark(opponent, move);
        }
        return board;
    }

    private int score(Board board, int depth) {
        if (board.isAWinFor(opponent)) {
            return -10 / depth;
        } else if (board.isAWinFor(mark)) {
            return 10 / depth;
        } else {
            return 0;
        }
    }

    private int bestMove() {
        Map.Entry<Integer, Integer> bestMove = null;
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
        return bestMove.getKey();
    }

    private int getBestMove(Board board) {
        negamax(board, 0, 1, -999, 999);
        return bestMove();
    }

    private void resetMoveSelection() {
        scores = new HashMap();
    }

    public Marks opponentMark() {
        return opponent;
    }
}
