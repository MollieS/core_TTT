public class GamePlay {
    private Game game;
    private Display display;
    private InputFeed input;

    public GamePlay(Game game, InputFeed input, Display output) {
        this.game = game;
        this.display = output;
        this.input = input;
    }

    public void start() {
        display.board(game);
        playGame();
        getGameResult();
    }

    private void getGameResult() {
        if (game.draw()) {
            display.draw();
        } else {
            write(game.winner().getMark() + " wins!");
        }
    }

    private void playGame() {
        while (!game.over()) {
            String choice = getLocation();
            try {
                int location = Integer.parseInt(choice);
                String message = game.play(location - 1);
                getStatus(message);
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
        } else {
            display.board(game);
        }
    }

    private String getLocation() {
        display.displayTurn(game);
        display.promptForLocation();
        return game.currentPlayer.getLocation(input, game.board);
    }

    private void write(String message) {
        display.write(message);
    }
}
