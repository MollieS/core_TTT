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
        for (int option = 0; option < locations.size(); option++) {
            if (!Objects.equals(board.get(locations.get(option)), " ")) {
                locations.remove(option);
            }
        }
        return locations;
    }

    private int bestMove(GameEngine game) {
        for (int location : availableLocations(game.board)) {
            game.board.placeMark(game.currentPlayer.getMark(), location);
            game.switchTurn();
            scores.put(location, bestMove(game));
        }
        return bestScore(scores);
    }

    private int score(GameEngine game) {
        if (game.winner().getMark().equals(opponent)) return -10;
        if (game.winner().getMark().equals(mark)) return 10;
        return 0;
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
