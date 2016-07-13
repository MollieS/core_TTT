package ttt.players;

import ttt.Input;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class HumanPlayer implements Player {

    private Marks mark;
    private Input input;

    public HumanPlayer(Marks mark, Input input) {
        this.input = input;
        this.mark = mark;
    }

    public Marks getMark() {
        return mark;
    }

    public int getLocation(Board board) throws Exception {
        return input.getUserLocation(board.availableMoves(), board.size());
    }

    public Class playerType() {
        return getClass();
    }

}
