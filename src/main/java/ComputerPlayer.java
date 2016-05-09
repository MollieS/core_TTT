import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer implements Player{

    private Randomizer randomizer;
    private List<String> locations = new ArrayList();
    private String mark;

    public ComputerPlayer(Randomizer randomizer, String mark) {
        this.randomizer = randomizer;
        for (int cells = 1; cells < 10; cells++) {
            locations.add(String.valueOf(cells));
        }
        this.mark = mark;
    }

    public String getLocation(InputFeed inputFeed, Board board) {
        return randomizer.location(availableLocations(board));
    }

    public List<String> availableLocations(Board board) {
        for (int option = 0; option < locations.size(); option++) {
            if(board.get((Integer.parseInt(locations.get(option))) - 1 ) != " ") {
                locations.remove(option);
            }
        }
        return locations;
    }

    public String getMark() {
        return mark;
    }
}
