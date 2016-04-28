public class GameInterface {
    private Input input;
    private Outputter output;
    public Player playerOne;
    public Player playerTwo;
    private Game game;

    public GameInterface(Input testInput, Outputter testOutput) {
        this.input = testInput;
        this.output = testOutput;
    }

    public void greet() {
        output.write("Welcome to Tic Tac Toe");
    }

    public void createPlayer() {
        output.write("Player One please choose a symbol");
        output.write("X or 0");
        String choice = loopForValidSymbol();
        setPlayerTwo(choice);
        output.write("Player One symbol is " + choice);
        output.write("Player Two symbol is " + playerTwo.getSymbol());
    }

    private void setPlayerTwo(String choice) {
        playerOne = new Player(choice);
        if (choice == "X") {
            playerTwo = new Player("0");
        } else {
            playerTwo = new Player("X");
        }
    }

    private String loopForValidSymbol() {
        String choice = input.get();
        while (choice != "X" && choice != "0") {
            output.write("Please choose X or 0");
            choice = input.get();
        }
        return choice;
    }

    public void setFirstPlayer() {
        String choice = input.get();
        Board board = new Board();
        if (choice == "1") {
            game = new Game(playerOne, playerTwo, board);
            output.write("Player One goes first");
        } else {
            game = new Game(playerTwo, playerOne, board);
            output.write("Player Two goes first");
        }
    }
}
