package ttt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimax {
    private Board board;
    private String maximizingPlayer;
    private String minimizingPlayer;
    private HashMap<Integer, Integer> scores = new HashMap<>();
    private Map.Entry<Integer, Integer> bestMove;

    public Minimax(String maximizingPlayer, String minimizingPlayer, Board board) {
        this.board = board;
        this.maximizingPlayer = maximizingPlayer;
        this.minimizingPlayer = minimizingPlayer;
    }

    public int bestMove() {
        negamax(board, 0, 1);
        return findBestMove();
    }


    public int negamax(Board board, int depth, int colour) {
        if (board.isFinished()) return score(board, depth) * colour;
        int bestValue = -999;
        for (int move : board.availableMoves()) {
            if (colour == 1) {
                board.placeMark(maximizingPlayer, move);
            } else {
                board.placeMark(minimizingPlayer, move);
            }
            int value = -negamax(board, depth - 1, -colour);
            board.clear(move);
            bestValue = Math.max(bestValue, value);
            if (depth == 0) scores.put(move, bestValue);
        }
        return bestValue;
    }

    private int findBestMove() {
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
        return bestMove.getKey();
    }

    private int score(Board board, int depth) {
        if (board.winFor(maximizingPlayer)) {
            return 10;
        } else if (board.winFor(minimizingPlayer)) {
            return -10;
        } else {
            return 0;
        }
    }

    public int minimax(Board board, String player) {
        if (board.isFinished()) {
            return score(board, 0);
        }
        List<Integer> moves = board.availableMoves();
        if (player == maximizingPlayer) {
            int bestValue = -999;
            for (int move = 0; move < board.availableMoves().size(); move++) {
                board.placeMark(player, moves.get(move));
                int value = minimax(board, minimizingPlayer);
                board.clear(moves.get(move));
                bestValue = Math.max(bestValue, value);
            }
            return bestValue;
        } else {
            int bestValue = 999;
            for (int move = 0; move < board.availableMoves().size(); move++) {
                board.placeMark(player, moves.get(move));
                int value = minimax(board, maximizingPlayer);
                board.clear(moves.get(move));
                bestValue = Math.min(bestValue, value);
            }
            return bestValue;
        }
    }
}
