package ttt.game;

import ttt.consoleui.Input;

public interface Player {

    Marks getMark();

    String getLocation(Input input, Board board);
}
