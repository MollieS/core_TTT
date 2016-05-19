package ttt;

import java.util.*;

public class PerfectPlayer implements Player {

    private Marks mark;
    private Marks opponent;
    private HashMap<Integer, Integer> scores = new HashMap<>();

    public PerfectPlayer(Marks mark) {
        this.mark = mark;
        this.opponent = mark.equals(Marks.X) ? Marks.O : Marks.X;
    }

    public String getLocation(Input input, Board board) {
        resetMoveSelection();
        int location = getBestMove(board);
        return String.valueOf(location);
    }


    public Marks getMark() {
        return mark;
    }

    private int negamax(Board board, int depth, int colour) {
        if (board.isFinished()) return score(board, depth) * colour;
        int bestValue = -999;
        for (int move : board.availableMoves()) {
            makeMove(board, colour, move);
            int value = -negamax(board, depth + 1, -colour);
            board.clear(move);
            bestValue = Math.max(value, bestValue);
            if (depth == 0) scores.put(move, bestValue);
        }
        return bestValue;
    }

    private void makeMove(Board board, int colour, int move) {
        if (colour == 1) {
            board.placeMark(mark, move);
        } else {
            board.placeMark(opponent, move);
        }
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
        negamax(board, 0, 1);
        return bestMove();
    }

    private void resetMoveSelection() {
        scores = new HashMap();
    }

    public Marks opponentMark() {
        return opponent;
    }
}
