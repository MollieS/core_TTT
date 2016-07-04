package ttt.players;

import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class RandomPlayer implements Player {

    final private Randomizer randomizer;
    final private Marks mark;

    public RandomPlayer(Randomizer randomizer, Marks mark) {
        this.randomizer = randomizer;
        this.mark = mark;
    }

    public Integer getLocation(Board board) {
        return randomizer.location(board.availableMoves());
    }

    public Class playerType() {
        return getClass();
    }

    public Marks getMark() {
        return mark;
    }
}
