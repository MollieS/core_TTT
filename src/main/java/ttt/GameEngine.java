package ttt;

import java.util.Arrays;
import java.util.List;

public class GameEngine {

    public Board board;
    public Player currentPlayer;
    public Player nextPlayer;
    private Player player1;
    private Player player2;

    public GameEngine(Player player1, Player player2, Board board) {
        this.board = board;
        this.currentPlayer = player1;
        this.nextPlayer = player2;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(int location) {
        board.placeMark(currentPlayer.getMark(), location);
        switchTurn();
    }

    public String board(int cell) {
        return board.get(cell);
    }

    public boolean isWon() {
        for (int position = 0; position < board.winningPositions().size(); position++) {
            if (winFor(player1.getMark(), position) || winFor(player2.getMark(), position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        return board.isFull() && !isWon();
    }

    public boolean isOver() {
        return (isWon() || isDraw());
    }

    public String winner() {
        return isWon() ? getWinner() : "Nothing";
    }

    private String getWinner() {
        return currentPlayer.equals(player1) ? player2.getMark() : player1.getMark();
    }

    private boolean winFor(String mark, int position) {
        List<String> win = Arrays.asList(mark, mark, mark);
        return board.winningPositions().get(position).equals(win);
    }

    public void switchTurn() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
            nextPlayer = player1;
        } else {
            currentPlayer = player1;
            nextPlayer = player2;
        }
    }

    private void makeMark(int location) {
        board.placeMark(currentPlayer.getMark(), location);
    }

    public String getBoardStatus() {
        return board.getStatus();
    }
}
