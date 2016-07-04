package ttt.players;

import ttt.Input;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class HumanPlayer implements Player {

    private Marks mark;
    private Input input;
    private int boardSize;

    public HumanPlayer(Marks mark, Input input, int boardSize) {
        this.input = input;
        this.mark = mark;
        this.boardSize = boardSize;
    }

    public Marks getMark() {
        return mark;
    }

    public Integer getLocation(Board board) throws Exception {
        return input.getUserLocation(board.availableMoves(), boardSize);
    }

    public Class playerType() {
        return getClass();
    }

}
