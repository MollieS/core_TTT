package ttt;


import java.util.*;

public class PerfectPlayer implements Player {

    private String mark;
    private String opponent;
    private HashMap<Integer, Integer> scores = new HashMap<>();
    private Map.Entry<Integer, Integer> bestMove = null;

    public PerfectPlayer(String mark) {
        this.mark = mark;
    }

    public int getLocation(Input input, GameEngine game) {
        opponent = mark.equals("X") ? "O" : "X";
        System.out.println(game.board.availableMoves());
        scores = new HashMap<Integer, Integer>();
        nega(game.board, 0, 1);
        System.out.println(bestMove);
        bestMove = null;
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
        bestMove = null;
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
        System.out.println(scores);
        System.out.println(bestMove.getKey());
        int currentBestMove = bestMove.getKey();
        bestMove = null;
        return currentBestMove;
    }
}
