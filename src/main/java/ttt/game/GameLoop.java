package ttt.game;

import ttt.consoleui.ConsoleBoard;
import ttt.Display;
import ttt.Input;

public class GameLoop {
    private GameEngine gameEngine;
    private Display display;
    private Input input;
    private ConsoleBoard consoleBoard;
    private final String[] replayOptions = {"y", "n"};

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
        write(consoleBoard.createBoard(gameEngine.showBoard()));
        if (gameEngine.isDraw()) {
            display.draw();
        } else {
            display.winner(gameEngine.winningMark());
        }
    }

    private void playGame() {
        while (!gameEngine.isOver()) {
            write(consoleBoard.createBoard(gameEngine.showBoard()));
            String input = getLocation();
            display.clearScreen();
            processInput(input);
        }
    }

    private String getLocation() {
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation(gameEngine.showBoard().size());
        return gameEngine.getCurrentPlayer().getLocation(gameEngine.showBoard());
    }

    private void placeMark(String input) {
        int choice = Integer.parseInt(input);
        gameEngine.play(choice);
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
        if (location < 0 || location > (gameEngine.showBoard().size() - 1)) {
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
        this.gameEngine = playAgain(input.getReplay());
        if (this.gameEngine != null) {
            start();
        }
    }

    public GameEngine playAgain(String answer) {
        GameEngine newGame = null;
        if (answer.equals(replayOptions[0])) {
            newGame = new GameMenu(input, display).createGame();
        } else if (answer.equals(replayOptions[1])) {
            display.goodbye();
        } else {
            display.invalidInput();
            playAgain(input.getReplay());
        }
        return newGame;
    }

    private void write(String message) {
        display.write(message);
    }
}
