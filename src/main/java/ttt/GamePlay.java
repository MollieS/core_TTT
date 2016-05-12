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
            write("available locations: " + gameEngine.board.availableMoves());
            Integer choice = getLocation();
            gameEngine.play(choice);
            String message = gameEngine.board.getStatus();
            getStatus(message);
            write(consoleBoard.update(gameEngine.nextPlayer.getMark(), choice));
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
