package ttt;

import ttt.game.Board;
import ttt.game.Marks;

public interface Player {

    Marks getMark();

    Integer getLocation(Board board) throws Exception;

    Class playerType();
}
