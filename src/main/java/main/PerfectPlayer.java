package main;

import java.util.*;

public class PerfectPlayer implements Player {

    private String mark;
    private List<Integer> locations = new ArrayList<>();
    private String opponent;
    private Integer depth = -1;
    private HashMap<Integer, Integer> scores = new HashMap<>();
    private Map.Entry<Integer, Integer> bestMove;

    public PerfectPlayer(String mark) {
        this.mark = mark;
        for (int cells = 0; cells < 9; cells++) {
            locations.add(cells);
        }
    }

    public int getLocation(Input input, GameEngine game) {
        opponent = mark.equals(input.markOne()) ? input.markTwo() : input.markOne();
        return bestMove(game);
    }

    public String getMark() {
        return mark;
    }

    public List<Integer> availableLocations(Board board) {
        List<Integer> availableLocations = new ArrayList<>();
        for (int option = 0; option < locations.size(); option++) {
            if (!board.get(option).contains("X") && !board.get(option).contains("O")) {
                availableLocations.add(locations.get(option));
            }
        }
        return availableLocations;
    }

    private int bestMove(GameEngine game) {
        for (int location : availableLocations(game.board)) {
            game.board.placeMark(game.currentPlayer.getMark(), location);
            game.switchTurn();
            scores.put(location, score(game));
        }
        return bestScore(scores);
    }

    private int score(GameEngine game) {
        if (game.isDraw()) {
            return 0;
        } else if (game.winner().getMark().equals(opponent)) {
            return -10;
        } else if (game.winner().getMark().equals(mark)) {
            return 10;
        } else {
            return 0;
        }
    }

    private int bestScore(HashMap<Integer, Integer> scores) {
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
        return bestMove.getKey();
    }
}
