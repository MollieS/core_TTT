public class GameSetup {

    private Input input;
    private Outputter output;
    public Player playerOne;
    public Player playerTwo;
    private Game game;

    public GameSetup(Input testInput, Outputter testOutput) {
        this.input = testInput;
        this.output = testOutput;
    }

    public Game setUpGame() {
        greet();
        createPlayer();
        setFirstPlayer();
        return game;
    }

    public void greet() {
        write("Welcome to Tic Tac Toe");
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
            output.write("Please choose X or O");
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
        write("Who goes first?  Please choose X or O");
        String choice = loopForValidSymbol();
        Board board = new Board();
        if (choice.equalsIgnoreCase("O") && playerTwo.getSymbol().equals("O")) {
            game = new Game(playerTwo, playerOne, board);
        } else if (choice.equalsIgnoreCase("X") && playerTwo.getSymbol().equals("X")) {
            game = new Game(playerTwo, playerOne, board);
        } else {
            game = new Game(playerOne, playerTwo, board);
        }
        write(game.currentPlayer.getSymbol() + " goes first");
    }

    private void write(String message) {
        output.write(message);
    }

    private void getPlayerSymbol() {
        write("Player One please choose a symbol");
        write("X or O");
        String choice = loopForValidSymbol();
        setPlayerTwo(choice);
        write("Player One's symbol is " + choice);
        write("Player Two's symbol is " + playerTwo.getSymbol());
    }
}
