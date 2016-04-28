import java.util.ArrayList;

public class TestInput implements Input {

    private ArrayList<String> stream = new ArrayList();

    public void set(String... words) {
        for (int word = 0; word < words.length; word ++){
           stream.add(words[word]);
        }
    }

    public String get() {
        return stream.remove(0);
    }
}
