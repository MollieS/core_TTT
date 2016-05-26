package ttt;

import java.util.ArrayList;

public class InputFake implements Input {

    private ArrayList<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word++) {
           stream.add(words[word]);
        }
    }

    public String get() {
        String input = stream.remove(0);
        if (validInput(input)) { return input; }
        return "-1";
    }

    public boolean validInput(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        String input = stream.remove(0);
        return input;
    }
}
