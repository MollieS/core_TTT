package ttt;

import ttt.game.BoardOption;
import ttt.game.GameOption;

import java.util.List;

public interface Input {

    Integer getUserLocation(List<Integer> availableMoves, int boardSize) throws Exception;

    String getReplay();

    Integer getGameChoice(GameOption[] options);

    Integer getBoardChoice(BoardOption[] options);
}

