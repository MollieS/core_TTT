import java.util.Arrays;
import java.util.List;

public class Game {

    private Board board;
    public Player currentPlayer;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2, Board board) {
        this.board = board;
        this.currentPlayer = player1;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(int location) {
        makeMark(location);
        switchTurn();
    }

    public String board(int cell) {
        return board.grid[cell];
    }

    public boolean won() {
        return isWon();
    }

    public boolean draw() {
        return isADraw();
    }

    public boolean over() {
        return isOver();
    }


    public Player winner() {
        return won() ? getWinner() : null;
    }

    private Player getWinner() {
        return currentPlayer == player1 ? player2 : player1;
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

    private void makeMark(int location) {
        board.placeMark(currentPlayer.getSymbol(), location);
    }

    private boolean isWon() {
        for (int position = 0; position < board.winningPositions().size(); position++) {
            if (winFor("X", position) || winFor("O", position)) {
                return true;
            }
        }
        return false;
    }

    private boolean isADraw() {
        return board.full() && !won();
    }

    private boolean isOver() {
        return (won() || draw());
    }
}
