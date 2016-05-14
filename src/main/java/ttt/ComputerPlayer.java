package ttt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComputerPlayer implements Player{

    private Randomizer randomizer;
    private List<Integer> locations = new ArrayList();
    private String mark;

    public ComputerPlayer(Randomizer randomizer, String mark) {
        this.randomizer = randomizer;
        for (int cells = 0; cells < 9; cells++) {
            locations.add(cells);
        }
        this.mark = mark;
    }

    public String getLocation(Input inputFeed, Board board) {
        int location = randomizer.location(board.availableMoves());
        return String.valueOf(location);
    }

    public String getMark() {
        return mark;
    }
}
