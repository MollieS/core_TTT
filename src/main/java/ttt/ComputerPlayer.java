package ttt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComputerPlayer implements Player{

    private Randomizer randomizer;
    private Marks mark;

    public ComputerPlayer(Randomizer randomizer, Marks mark) {
        this.randomizer = randomizer;
        this.mark = mark;
    }

    public String getLocation(Input input, Board board) {
        int location = randomizer.location(board.availableMoves());
        return String.valueOf(location);
    }

    public Marks getMark() {
        return mark;
    }
}
