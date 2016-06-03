package ttt;

import java.util.ArrayList;
import java.util.List;

public class InputFake implements Input {

    private ArrayList<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word++) {
           stream.add(words[word]);
        }
    }

    public String getUserChoice() {
        String input = stream.remove(0);
        if (isAnInteger(input)) { return input; }
        return "-1";
    }

    public boolean isAnInteger(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        String input = stream.remove(0);
        return input;
    }


    public int getMenuChoice(List<Integer> options) {
        String input = stream.remove(0);
        int choice;
        if (isAnInteger(input)) {
            choice = Integer.parseInt(input);
        } else {
            choice = 0;
        }
        if (options.contains(choice)) return choice;
        return 0;
    }

}
