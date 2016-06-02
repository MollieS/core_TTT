package ttt.players;

import ttt.game.Board;
import ttt.game.Marks;
import ttt.Player;

public class ComputerPlayer implements Player {

    final private Randomizer randomizer;
    final private Marks mark;

    public ComputerPlayer(Randomizer randomizer, Marks mark) {
        this.randomizer = randomizer;
        this.mark = mark;
    }

    public String getLocation(Board board) {
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        int location = randomizer.location(board.availableMoves());
        return String.valueOf(location);
    }

    public Marks getMark() {
        return mark;
    }
}
