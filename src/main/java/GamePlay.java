public class GamePlay {
    private Game game;
    private Outputter output;
    private Input input;

    public GamePlay(Game game, Input input, Outputter output) {
        this.game = game;
        this.output = output;
        this.input = input;
    }

    public void start() {
        write(displayBoard());
        playGame();
        getGameResult();
    }

    private void getGameResult() {
        if (game.draw()) {
            write("It's a draw!");
        } else {
            write(game.winner().getSymbol() + " wins!");
        }
    }

    private void playGame() {
        while (!game.over()) {
            write(game.currentPlayer.getSymbol() + "'s turn: choose a location");
            write("Please choose from 1 to 9");
            String choice = read();
            int location = Integer.parseInt(loopForValidInput(choice));
            game.play(location - 1);
            write(displayBoard());
        }
    }

    private String loopForValidInput(String choice) {
        while (!validLocation(choice)) {
            write("Please choose a number from 1 to 9");
            choice = read();
        }
        return choice;
    }

    private boolean validLocation(String choice) {
        for (int location = 1; location < 10; location++) {
            if ((Integer.toString(location)).contains(choice) && !cellIsTaken(choice)) {
                return true;
            }
        }
        return false;
    }

    private boolean cellIsTaken(String choice) {
        if (!game.board((Integer.valueOf(choice) - 1)).equals(" ")) {
            write("Already taken");
            return true;
        }
        return false;
    }

    public String displayBoard() {
        String rows = "";
        rows += firstRow();
        rows = drawBoard(rows);
        rows += lastRow();
        return rows;
    }


    private String firstRow() {
        return "-------------\n";
    }

    private String lastRow() {
        return "|\n-------------";
    }

    private String drawBoard(String rows) {
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                rows += "|\n-------------\n";
            }
            rows += "| " + game.board(cell) + " ";
        }
        return rows;
    }

    private boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }

    private void write(String message) {
        output.write(message);
    }

    private String read() {
        return input.get();
    }
}
