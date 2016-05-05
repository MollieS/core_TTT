import com.sun.tools.javac.util.Names;

public class GameMenu {

    private InputFeed inputFeed;
    private Display display;

    public GameMenu(InputFeed inputFeed, Display display) {
        this.inputFeed = inputFeed;
        this.display = display;
    }

    public void show() {
        display.gameOptions();
    }

    public Player createOpponent(String gameChoice) {
        if (gameChoice.equals("1")) {
            return new HumanPlayer("O");
        } else {
            return new ComputerPlayer(new RandomLocationGenerator(), "O");
        }
    }

    public Game createGame() {
        display.greet();
        display.gameOptions();
        Board board = new Board();
        return new Game(new HumanPlayer("X"), createOpponent(inputFeed.get()), board);
    }
}
