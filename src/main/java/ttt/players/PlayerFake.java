package ttt.players;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class PlayerFake implements Player {

    private Marks mark;

    public PlayerFake(Marks mark) {
        this.mark = mark;
    }

    public Marks getMark() {
        return mark;
    }

    public int getLocation(Board board) throws Exception {
        return 0;
    }

    public Class playerType() {
        return getClass();
    }
}
