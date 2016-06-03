package ttt;

import java.util.List;

public interface Input {
    String getUserChoice();

    boolean isAnInteger(String input);

    String getReplay();

    int getMenuChoice(List<Integer> options);

}

