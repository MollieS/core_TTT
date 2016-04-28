import java.util.Arrays;
import java.util.List;

public class Game {

    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2, Board board) {
        this.board = board;
        this.currentPlayer = player1;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(int location) {
        board.placeMark(currentPlayer.getSymbol(), location);
        switchTurn();
    }

    public String board(int cell) {
        return board.grid[cell];
    }

    public boolean won() {
        for (int position = 0; position < board.winningPositions().size(); position++) {
            if (winFor("X", position) || winFor("O", position)) {
                return true;
            }
        }
        return false;
    }

    public boolean draw() {
        return board.full() && !won();
    }

    public boolean over() {
        return won() || draw();
    }

    public Player winner() {
        if (won()) {
            return getWinner();
        }
        return null;
    }

    private Player getWinner() {
        if (currentPlayer == player1) {
            return player2;
        } else {
            return player1;
        }
    }

    private boolean winFor(String symbol, int position) {
        List<String> win = Arrays.asList(symbol, symbol, symbol);
        return board.winningPositions().get(position).equals(win);
    }

    private void switchTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
