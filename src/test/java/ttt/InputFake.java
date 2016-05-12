package ttt;

import java.util.ArrayList;

public class InputFake implements Input {

    private ArrayList<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word ++){
           stream.add(words[word]);
        }
    }

    public String markOne() {
        return "O";
    }

    public String markTwo() {
        return "X";
    }

    public String get() {
        return stream.remove(0);
    }
}
