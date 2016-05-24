package ttt;

import ttt.game.Board;
import ttt.game.Marks;

public interface Player {

    Marks getMark();

    String getLocation(Input input, Board board);
}
