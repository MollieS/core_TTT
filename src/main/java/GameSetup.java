public class GameSetup {

    private InputFeed input;
    private Display display;
    public Player playerOne;
    public Player playerTwo;
    private Game game;

    public GameSetup(InputFeed input, Display display) {
        this.input = input;
        this.display = display;
    }

    public Game setUpGame() {
        greet();
        createPlayer();
        setFirstPlayer();
        return game;
    }

    public void greet() {
        display.greet();
    }

    public void createPlayer() {
        getPlayerSymbol();
    }

    public void setFirstPlayer() {
        findFirstPlayer();
    }

    private String loopForValidSymbol() {
        String choice = input.get();
        while (!choice.equalsIgnoreCase("X") && !choice.equalsIgnoreCase("O")) {
            display.promptForMark();
            choice = input.get();
        }
        return choice.toUpperCase();
    }

    private void setPlayerTwo(String choice) {
        playerOne = new Player(choice);
        if (choice.equalsIgnoreCase("X")) {
            playerTwo = new Player("O");
        } else {
            playerTwo = new Player("X");
        }
    }

    private void findFirstPlayer() {
        display.promptForFirstGo();
        String choice = loopForValidSymbol();
        Board board = new Board();
        if (choice.equalsIgnoreCase("O") && playerTwo.getMark().equals("O")) {
            game = new Game(playerTwo, playerOne, board);
        } else if (choice.equalsIgnoreCase("X") && playerTwo.getMark().equals("X")) {
            game = new Game(playerTwo, playerOne, board);
        } else {
            game = new Game(playerOne, playerTwo, board);
        }
    }

    private void getPlayerSymbol() {
        display.promptForMark();
        String choice = loopForValidSymbol();
        setPlayerTwo(choice);
        display.displayMarks(choice, playerTwo.getMark());
    }
}
