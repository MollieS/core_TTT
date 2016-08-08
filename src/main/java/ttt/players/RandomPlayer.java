package ttt.players;

import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class RandomPlayer implements Player {

    private final Randomizer randomizer;
    private final Marks mark;

    public RandomPlayer(Randomizer randomizer, Marks mark) {
        this.randomizer = randomizer;
        this.mark = mark;
    }

    public int getLocation(Board board) {
        return randomizer.location(board.availableMoves());
    }

    public Class playerType() {
        return getClass();
    }

    public Marks getMark() {
        return mark;
    }
}
