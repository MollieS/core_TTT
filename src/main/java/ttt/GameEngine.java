package ttt;

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

    public void switchTurn() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
            nextPlayer = player1;
        } else {
            currentPlayer = player1;
            nextPlayer = player2;
        }
    }

    public Marks board(int cell) {
        return board.getAt(cell);
    }

    public boolean isWon() {
        return board.isWon();
    }

    public boolean isDraw() {
        return board.isDraw();
    }

    public boolean isOver() {
        return board.isFinished();
    }

    public Marks winningMark() {
        if (board.isAWinFor(currentPlayer.getMark())) return currentPlayer.getMark();
        return nextPlayer.getMark();
    }
}
