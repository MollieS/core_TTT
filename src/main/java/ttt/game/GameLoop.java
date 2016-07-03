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
        display.clearScreen();
        write(consoleBoard.createBoard(gameEngine.showBoard()));
        playGame();
        getGameResult();
        replay();
    }

    private void playGame() {
        while (!gameEngine.isOver()) {
            Exception exception = null;
            Integer location = null;
            try {
                location = getLocation();
            } catch (Exception e) {
                exception = e;
            }
            display.clearScreen();
            processOutput(exception, location);
        }
    }

    private void processOutput(Exception exception, Integer location) {
        if (exception != null) {
            displayErrorMessage(exception);
        } else {
            processInput(location);
        }
    }

    private void displayErrorMessage(Exception exception) {
        display.write(consoleBoard.createBoard(gameEngine.showBoard()));
        display.write(exception.getMessage());
    }

    private Integer getLocation() throws Exception {
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation(gameEngine.showBoard().size());
        return gameEngine.getCurrentPlayer().getLocation(gameEngine.showBoard());
    }

    private void placeMark(Integer input) {
        gameEngine.play(input);
    }

    private void processInput(Integer input) {
        placeMark(input);
        write(consoleBoard.createBoard(gameEngine.showBoard()));
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
        if (answer == null) {
            display.invalidInput();
            playAgain(input.getReplay());
        } else if (answer.equals(replayOptions[0])) {
            newGame = new GameMenu(input, display).createGame();
        } else if (answer.equals(replayOptions[1])) {
            display.goodbye();
        }
        return newGame;
    }

    private void write(String message) {
        display.write(message);
    }

    private void getGameResult() {
        if (gameEngine.isDraw()) {
            display.draw();
        } else {
            display.winner(gameEngine.winningMark());
        }
    }
}
