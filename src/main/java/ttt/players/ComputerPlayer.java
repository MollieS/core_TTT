package ttt.players;

import ttt.Input;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class ComputerPlayer implements Player {

    private Randomizer randomizer;
    private Marks mark;

    public ComputerPlayer(Randomizer randomizer, Marks mark) {
        this.randomizer = randomizer;
        this.mark = mark;
    }

    public String getLocation(Board board) {
        int location = randomizer.location(board.availableMoves());
        return String.valueOf(location);
    }

    public Marks getMark() {
        return mark;
    }
}
