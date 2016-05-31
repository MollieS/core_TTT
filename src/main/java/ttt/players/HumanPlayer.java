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

    public String getLocation(Board board) {
        return formatLocation(input);
    }

    private String formatLocation(Input input) {
        int location = Integer.parseInt((input.get()));
        return String.valueOf(location - 1);
    }
}
