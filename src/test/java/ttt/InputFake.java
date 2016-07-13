package ttt;

import ttt.game.BoardOption;
import ttt.game.GameOption;
import ttt.game.Options;

import java.util.ArrayList;
import java.util.List;

public class InputFake implements Input {

    private List<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word++) {
           stream.add(words[word]);
        }
    }

    public String getReplay() {
        return stream.remove(0);
    }

    public Integer getBoardChoice(BoardOption[] options) {
        String input = stream.remove(0);
        for (BoardOption option : options) {
            if (input.equals(option.key)) {
                return Integer.valueOf(input);
            }
        }
        return null;
    }

    public Integer getUserLocation(List<Integer> board, int boardSize) throws GameException {
        String input = stream.remove(0);
        if (!isAnInteger(input)) { throw GameException.notANumber(); }
        int location = (Integer.parseInt(input) - 1);
        if (board.contains(location)) { return location; }
        if (location > (boardSize * boardSize)) {
            throw GameException.outOfBounds();
        } else {
            throw GameException.takenCell();
        }
    }

    public Integer getGameChoice(GameOption[] options) {
        String input = stream.remove(0);
        for (GameOption option : options) {
            if (input.equals(option.key)) {
                return Integer.valueOf(input);
            }
        }
        return null;
    }

    private boolean isAnInteger(String input) {
        return input.matches("[0-9]+");
    }
}
