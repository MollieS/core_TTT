package ttt;

import ttt.game.Board;
import ttt.game.Marks;

public class PlayerFake implements Player {

    public Marks getMark() {
        return Marks.X;
   }

    public int getLocation(Board board) throws Exception {
        return 0;
    }

    public Class playerType() {
        return null;
    }
}
