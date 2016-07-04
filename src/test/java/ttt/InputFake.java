package ttt;

import java.util.ArrayList;
import java.util.List;

public class InputFake implements Input {

    private List<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word++) {
           stream.add(words[word]);
        }
    }

    public boolean isAnInteger(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        return stream.remove(0);
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

    public Integer getMenuChoice(List<Integer> options) {
        String input = stream.remove(0);
        int choice;
        if (isAnInteger(input)) {
            choice = convertToInt(input);
        } else {
            choice = 0;
        }
        if (options.contains(choice)) return choice;
        return null;
    }

    private int convertToInt(String input) {
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            choice = 0;
        }
        return choice;
    }

}
