package ttt;

import java.util.List;

public interface Input {

    boolean isAnInteger(String input);

    String getReplay();

    Integer getMenuChoice(List<Integer> options);

    Integer getUserLocation(List<Integer> availableMoves, int boardSize) throws Exception;
}

