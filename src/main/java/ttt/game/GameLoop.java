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
            Integer location = getLocation();
            display.clearScreen();
            processInput(location);
        }
    }

    private Integer getLocation() {
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation(gameEngine.showBoard().size());
        return gameEngine.getCurrentPlayer().getLocation(gameEngine.showBoard());
    }

    private void placeMark(Integer input) {
        gameEngine.play(input);
    }

    private void processInput(Integer input) {
        if (input == null) {
            write(consoleBoard.createBoard(gameEngine.showBoard()));
            display.invalidInput();
        } else {
            placeMark(input);
            write(consoleBoard.createBoard(gameEngine.showBoard()));
        }
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
        }
        if (answer.equals(replayOptions[0])) {
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
        write(consoleBoard.createBoard(gameEngine.showBoard()));
        if (gameEngine.isDraw()) {
            display.draw();
        } else {
            display.winner(gameEngine.winningMark());
        }
    }
}
