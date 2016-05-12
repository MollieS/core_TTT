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

    public int getLocation(Input inputFeed, GameEngine game) {
        return randomizer.location(availableLocations(game.board));
    }

    public List<Integer> availableLocations(Board board) {
        for (int option = 0; option < locations.size(); option++) {
            if(!Objects.equals(board.get(locations.get(option)), " ")) {
                locations.remove(option);
            }
        }
        return board.availableMoves();
    }

    public String getMark() {
        return mark;
    }
}
