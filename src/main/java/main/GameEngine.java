package main;

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


    public Player winner() {
        return isWon() ? getWinner() : null;
    }

    private Player getWinner() {
        return currentPlayer == player1 ? player2 : player1;
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

    private String makeMark(int location) {
        return board.placeMark(currentPlayer.getMark(), location);
    }
}
