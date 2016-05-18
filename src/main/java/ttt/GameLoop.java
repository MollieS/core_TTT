package ttt;

public class GameLoop {
    private GameEngine gameEngine;
    private Display display;
    private Input input;
    private ConsoleBoard consoleBoard;

    public GameLoop(GameEngine gameEngine, Input input, Display output, ConsoleBoard consoleBoard) {
        this.gameEngine = gameEngine;
        this.display = output;
        this.input = input;
        this.consoleBoard = consoleBoard;
    }

    public void start() {
        playGame();
        getGameResult();
        replay();
    }

    private void getGameResult() {
        if (gameEngine.isDraw()) {
            display.draw();
        } else {
            display.winner(gameEngine.winningMark());
        }
    }

    private void playGame() {
        while (!gameEngine.isOver()) {
            String input = getLocation();
            display.clearScreen();
            processInput(input);
        }
    }

    private String getLocation() {
        write(consoleBoard.createBoard(gameEngine.showBoard()));
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation();
        return gameEngine.getCurrentPlayer().getLocation(input, gameEngine.showBoard());
    }

    private void placeMark(String input) {
        int choice = Integer.parseInt(input);
        gameEngine.play(choice);
        write(consoleBoard.createBoard(gameEngine.showBoard()));
    }

    private void processInput(String input) {
        if (isInvalidInput(input)) {
            display.invalidInput();
        } else {
            placeMark(input);
        }
    }

    private boolean isInvalidInput(String choice) {
        int location = Integer.parseInt(choice);
        if (location < 0 || location > 8) {
            display.invalidLocation();
            return true;
        } else if (gameEngine.board(location) != Marks.CLEAR) {
            display.takenCell();
            return true;
        }
        return false;
    }

    private void replay() {
        display.replay();
        playAgain(input.get());
        display.goodbye();
    }

    private void playAgain(String answer) {
        if (answer.equals("1")) {
            this.gameEngine = new GameMenu(input, display).createGame();
            start();
        }
    }

    private void write(String message) {
        display.write(message);
    }
}
