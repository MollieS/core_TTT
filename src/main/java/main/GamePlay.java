package main;

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
            write(gameEngine.winner().getMark() + " wins!");
        }
    }

    private void playGame() {
        while (!gameEngine.isOver()) {
            try {
                Integer choice = getLocation();
                String message = gameEngine.play(choice);
                getStatus(message);
                write(consoleBoard.update(gameEngine.nextPlayer.getMark(), choice));
            } catch (NumberFormatException e) {
                display.invalidInput();
            }
        }
    }

    private void getStatus(String message) {
        if (message.equals("taken")) {
            display.takenCell();
        } else if (message.equals("invalid location")) {
            display.invalidLocation();
        }
    }

    private int getLocation() {
        display.displayTurn(gameEngine.currentPlayer.getMark());
        display.promptForLocation();
        return gameEngine.currentPlayer.getLocation(input, gameEngine);
    }

    private void write(String message) {
        display.write(message);
    }
}
