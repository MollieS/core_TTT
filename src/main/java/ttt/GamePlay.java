package ttt;

public class GamePlay {
    private GameEngine gameEngine;
    private Display display;
    private Input input;
    private ConsoleBoard consoleBoard;

    public GamePlay(GameEngine gameEngine, Input input, Display output, ConsoleBoard consoleBoard) {
        this.gameEngine = gameEngine;
        this.display = output;
        this.input = input;
        this.consoleBoard = consoleBoard;
    }

    public void start() {
        write(consoleBoard.show());
        playGame();
        getGameResult();
    }

    private void getGameResult() {
        if (gameEngine.isDraw()) {
            display.draw();
        } else {
            write(gameEngine.winner() + " wins!");
        }
    }

    private void playGame() {
        while (!gameEngine.isOver()) {
            String input = getLocation();
            display.clearScreen();
            if (isInvalidInput(input)) {
                write(consoleBoard.show());
                write("Please choose a valid option");
            } else {
                placeMark(input);
            }
        }
    }

    private void placeMark(String input) {
        int choice = Integer.parseInt(input);
        gameEngine.play(choice);
        write(consoleBoard.update(gameEngine.currentPlayer.getMark(), choice));
    }

    private boolean isInvalidInput(String choice) {
        int location = Integer.parseInt(choice);
        if (location < 0 || location > 8) {
            return true;
        } else if (gameEngine.board.getAt(location) != Marks.CLEAR) {
            return true;
        }
        return false;
    }

    private void invalidInput(String message) {
        if (message.equals("taken")) {
            display.takenCell();
        } else if (message.equals("invalid location")) {
            display.invalidLocation();
        }
    }

    private String getLocation() {
        display.displayTurn(gameEngine.currentPlayer.getMark());
        display.promptForLocation();
        return gameEngine.currentPlayer.getLocation(input, gameEngine.board);
    }

    private void write(String message) {
        display.write(message);
    }
}
