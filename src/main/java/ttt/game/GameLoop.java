package ttt.game;

import ttt.BoardDisplay;
import ttt.Display;

public class GameLoop {
    private GameEngine gameEngine;
    private Display display;
    private BoardDisplay boardDisplay;
    private Board board;
    private Integer nextMove;

    public GameLoop(GameEngine gameEngine, Display output, BoardDisplay boardDisplay) {
        this.gameEngine = gameEngine;
        this.display = output;
        this.boardDisplay = boardDisplay;
        this.board = gameEngine.showBoard();
    }

    public GameLoop(GameEngine gameEngine) {
        this.nextMove = getLocation();
        this.gameEngine = gameEngine;
        this.board = gameEngine.showBoard();
    }

    public void start() {
        clearScreen();
        showBoard();
        playGame();
        getGameResult();
    }

    public void playGame() {
        while (!gameEngine.isOver()) {
            Exception exception = null;
            Integer location = null;
            try {
                location = getPlayerMove();
            } catch (Exception e) {
                exception = e;
            }
            showBoard(exception, location);
        }
    }

    public void playMoves() {
        if (nextMove != null && !gameEngine.isOver()) {
            gameEngine.play(nextMove);
            nextMove = getPlayerMove();
            gameEngine.play(nextMove);
        }
    }

    private void showBoard(Exception exception, Integer location) {
        clearScreen();
        processOutput(exception, location);
    }

    private void clearScreen() {
        display.clearScreen();
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

    private Integer getLocation() {
        display.displayTurn(gameEngine.currentMark());
        display.promptForLocation(gameEngine.boardSize());
        return getPlayerMove();
    }

    private Integer getPlayerMove() {
        try {
            return gameEngine.getPlayerMove(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
