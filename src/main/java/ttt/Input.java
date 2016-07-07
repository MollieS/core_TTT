package ttt;

import java.util.List;

public interface Input {

    Integer getUserLocation(List<Integer> availableMoves, int boardSize) throws Exception;
}

