package ttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private Marks[] board = new Marks[9];

    public Board() {
        for (int cell = 0; cell < 9; cell++) {
            board[cell] = Marks.CLEAR;
        }
    }

    public void placeMark(Marks mark, int location) {
        board[location] = mark;
    }

    public int size() {
        return board.length;
    }

    public Marks getMarkAt(int cell) {
        return board[cell];
    }

    public void clear(int location) {
        board[location] = Marks.CLEAR;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell] == Marks.CLEAR) moves.add(cell);
        }
        return moves;
    }

    public boolean isFull() {
        for (Marks cell : board) if (cell == Marks.CLEAR) { return false; }
        return true;
    }

    public boolean isEmpty() {
        for (Marks cell : board) if (cell != Marks.CLEAR) { return false; }
        return true;
    }

    public boolean isDraw() {
        return isFull() && !isWon();
    }

    public boolean isFinished() {
        return isDraw() || isWon();
    }

    public boolean isAWinFor(Marks mark) {
        for (List<Marks> cells : winningPositions()) {
            if (isAllTheSame(mark, cells)) return true;
        }
        return false;
    }

    private boolean isAllTheSame(Marks mark, List<Marks> cells) {
        return Collections.frequency(cells, mark) == 3;
    }

    public boolean isWon() {
        for (List<Marks> cells : winningPositions()) {
            if (isAllTheSame(Marks.O, cells)) return true;
            if (isAllTheSame(Marks.X, cells)) return true;
        }
        return false;
    }

    public List<List<Marks>> winningPositions() {
        List<List<Marks>> positions = rows();
        positions.addAll(columns());
        positions.addAll(diagonals());
        return positions;
    }

    private List<List<Marks>> rows() {
        int rowStart = 0;
        List<List<Marks>> rows = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            rows.add(Arrays.asList(board[rowStart], board[rowStart + 1], board[rowStart + 2]));
            rowStart += 3;
        }
        return rows;
    }

    private List<List<Marks>> columns() {
        int columnStart = 0;
        List<List<Marks>> columns = new ArrayList<>();
        for (int cell = 0; cell < 3; cell ++) {
            columns.add(Arrays.asList(board[columnStart], board[columnStart + 3], board[columnStart + 6]));
            columnStart ++;
        }
        return columns;
    }

    private List<List<Marks>> diagonals() {
        List<Marks> left = Arrays.asList(board[0], board[4], board[8]);
        List<Marks> right = Arrays.asList(board[2], board[4], board[6]);
        return Arrays.asList(left, right);
    }
}
