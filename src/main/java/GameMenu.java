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
        Game game = new Game(new HumanPlayer("X"), createOpponent(loopForValidInput(inputFeed.get())), board);
        display.displayMarks(game.player1.getMark(), game.player2.getMark());
        return game;
    }

    private String loopForValidInput(String input) {
        while (!validInput(input)) {
            display.invalidInput();
            input = inputFeed.get();
        }
        return input;
    }
    private boolean validInput(String input) {
        return (input.equals("1") || input.equals("2"));
    }
}
