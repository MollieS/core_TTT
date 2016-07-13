package ttt.game;

import ttt.BoardDisplay;
import ttt.Display;
import ttt.Input;

public class GameLoop {
    private GameEngine gameEngine;
    private Display display;
    private BoardDisplay boardDisplay;
    private final String[] replayOptions = {"y", "n"};
    private Board board;

    public GameLoop(GameEngine gameEngine, Display output, BoardDisplay boardDisplay) {
        this.gameEngine = gameEngine;
        this.display = output;
        this.boardDisplay = boardDisplay;
        this.board = gameEngine.showBoard();
    }

    public void start() {
        display.clearScreen();
        showBoard();
        playGame();
        getGameResult();
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
        display.write(boardDisplay.createBoard(board));
        display.write(exception.getMessage());
    }

    private Integer getLocation() throws Exception {
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation(gameEngine.boardSize());
        return gameEngine.getPlayerMove(board);
    }

    private void placeMark(Integer input) {
        board = gameEngine.play(input);
    }

    private void processInput(Integer input) {
        placeMark(input);
        showBoard();
    }

    private void showBoard() {
        write(boardDisplay.createBoard(board));
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
