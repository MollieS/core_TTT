package ttt;


import java.util.*;

public class PerfectPlayer implements Player {

    private String mark;
    private String opponent;
    private HashMap<Integer, Integer> scores;
    private Map.Entry<Integer, Integer> bestMove;

    public PerfectPlayer(String mark) {
        this.mark = mark;
    }

    public int getLocation(Input input, GameEngine game) {
        opponent = mark.equals("X") ? "O" : "X";
        scores = new HashMap<>();
        nega(game.board, 0, 1);
        return bestMove();
    }

    public String getMark() {
        return mark;
    }

    private int nega(Board board, int depth, int colour) {
        if (board.isFinished()) return score(board, depth) * colour;
        int bestValue = -999;
        for (int move : board.availableMoves()) {
            if (colour == 1) {
                board.placeMark(mark, move);
            } else {
                board.placeMark(opponent, move);
            }
            int value = -nega(board, depth + 1, -colour);
            board.clear(move);
            bestValue = Math.max(value, bestValue);
            if (depth == 0) scores.put(move, bestValue);
        }
        if (depth == 0) return bestMove();
        return bestValue;
    }

    private int score(Board board, int depth) {
        if (board.winFor(opponent)) {
            return -10 / depth;
        } else if (board.winFor(mark)) {
            return 10 / depth;
        } else {
            return 0;
        }
    }

    private int bestMove() {
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
        return bestMove.getKey();
    }
}
