package main;

public class GameMenu {

    private Input input;
    private Display display;

    public GameMenu(Input input, Display display) {
        this.input = input;
        this.display = display;
    }

    public void show() {
        display.gameOptions();
    }

    public Player createOpponent(String gameChoice) {
        if (gameChoice.equals("1")) {
            return new HumanPlayer(input.markTwo());
        } else {
            return new ComputerPlayer(new RandomLocationGenerator(), input.markTwo());
        }
    }

    public GameEngine createGame() {
        display.greet();
        display.gameOptions();
        Board board = new Board();
        GameEngine gameEngine = new GameEngine(new HumanPlayer(input.markOne()), createOpponent(loopForValidInput(input.get())), board);
        display.displayMarks(gameEngine.currentPlayer.getMark(), gameEngine.nextPlayer.getMark());
        return gameEngine;
    }

    private String loopForValidInput(String userInput) {
        while (!validInput(userInput)) {
            display.invalidInput();
            userInput = input.get();
        }
        return userInput;
    }
    private boolean validInput(String input) {
        return (input.equals("1") || input.equals("2"));
    }
}
