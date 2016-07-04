package ttt.players;

import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class RandomPlayer implements Player {

    private final Randomizer randomizer;
    private final Marks mark;
    private final Delay delay;

    public RandomPlayer(Randomizer randomizer, Marks mark, Delay delay) {
        this.randomizer = randomizer;
        this.mark = mark;
        this.delay = delay;
    }

    public Integer getLocation(Board board) {
        Integer move = randomizer.location(board.availableMoves());
        return delay.delayMove(move);
    }

    public Marks getMark() {
        return mark;
    }
}
