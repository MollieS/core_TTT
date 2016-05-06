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

    public String play(int location) {
        String moveStatus = makeMark(location);
        if (moveStatus.equals("mark placed")) {
            switchTurn();
        }
            return moveStatus;
    }

    public String board(int cell) {
        return board.get(cell);
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
        return (won() || draw());
    }


    public Player winner() {
        return won() ? getWinner() : null;
    }

    private Player getWinner() {
        return currentPlayer == player1 ? player2 : player1;
    }

    private boolean winFor(String mark, int position) {
        List<String> win = Arrays.asList(mark, mark, mark);
        return board.winningPositions().get(position).equals(win);
    }

    private void switchTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private String makeMark(int location) {
        return board.placeMark(currentPlayer.getMark(), location);
    }
}
