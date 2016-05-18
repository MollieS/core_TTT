package ttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private Marks[] board;
    private final Marks emptyCell;
    private int size;

    public Board(int size) {
        this.size = size;
        int boardSize = (size * size);
        this.board = new Marks[boardSize];
        this.emptyCell = Marks.CLEAR;
        for (int cell = 0; cell < boardSize; cell++) {
            board[cell] = emptyCell;
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
        board[location] = emptyCell;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell].equals(emptyCell)) moves.add(cell);
        }
        return moves;
    }

    public boolean isFull() {
        for (Marks cell : board) if (cell.equals(emptyCell)) { return false; }
        return true;
    }

    public boolean isEmpty() {
        for (Marks cell : board) if (!cell.equals(emptyCell)) { return false; }
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
            if (Collections.frequency(cells, mark) == size) return true;
        }
        return false;
    }

    public boolean isWon() {
        for (List<Marks> cells : winningPositions()) {
            if (Collections.frequency(cells, Marks.O) == size) return true;
            if (Collections.frequency(cells, Marks.X) == size) return true;
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
        for (int i = 0; i < size; i++) {
            List<Marks> cells = new ArrayList<>();
            for (int cell = 0; cell < size; cell++) {
                cells.add(board[cell + rowStart]);
            }
            rows.add(cells);
            rowStart += size;
        }
        return rows;
    }

    private List<List<Marks>> columns() {
        int columnStart = 0;
        List<List<Marks>> columns = new ArrayList<>();
        for (int cell = 0; cell < size; cell ++) {
            List<Marks> cells = new ArrayList<>();
            for (int i = columnStart; i < size(); i += size) {
                cells.add(board[i]);
            }
            columns.add(cells);
            columnStart ++;
        }
        return columns;
    }

    private List<List<Marks>> diagonals() {
        List<Marks> left = leftDiagonal();
        List<Marks> right = rightDiagonal();
        return Arrays.asList(left, right);
    }

    private List<Marks> leftDiagonal() {
        List<Marks> left = new ArrayList();
        for (int i = 0; i < size(); i += (size + 1)) {
            left.add(board[i]);
        }
        return left;
    }

    public List<Marks> rightDiagonal() {
        List<Marks> right = new ArrayList();
        for (int i = (size - 1); i < (size() -1); i += (size - 1)) {
            right.add(board[i]);
        }
        return right;
    }
}
