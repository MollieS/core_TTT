package ttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private Marks[] board = new Marks[9];
    private final Marks emptyCell;
    private Marks winningMark;

    public Board() {
        this.emptyCell = Marks.CLEAR;
        this.winningMark = null;
        for (int cell = 0; cell < 9; cell++) {
            board[cell] = emptyCell;
        }
    }

    public void placeMark(Marks mark, int location) {
        board[location] = mark;
    }

    public int size() {
        return board.length;
    }

    public Marks getAt(int cell) {
        return board[cell];
    }

    public Marks getWinningMark() {
        return winningMark;
    }

    public boolean isAWinFor(Marks mark) {
        return isWon() && winningMark.equals(mark);
    }

    public void clear(int location) {
        board[location] = emptyCell;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell].equals(emptyCell)) {
                moves.add(cell);
            }
        }
        return moves;
    }

    public List<List<Marks>> winningPositions() {
        List<List<Marks>> positions = new ArrayList<>();
        positions.addAll(rows());
        positions.addAll(columns());
        positions.addAll(diagonals());
        return positions;
    }


    public boolean isFull() {
        for (Marks cell : board) {
            if (cell.equals(emptyCell)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (Marks cell : board) {
            if (!cell.equals(emptyCell)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDraw() {
        return (isFull() && !isWon());
    }

    public boolean isFinished() {
        return (isDraw() || isWon());
    }

    public boolean isWon() {
        for (List<Marks> selection : winningPositions()) {
            if (isAWin(selection)) {
                return true;
            }
        }
        return false;
    }

    private List<Marks> getSelection(int first, int middle, int last) {
        return Arrays.asList(board[first], board[middle], board[last]);
    }

    private boolean isAWin(List<Marks> selection) {
        if (selection.get(0).equals(emptyCell)) return false;
        if (!selection.get(0).equals(selection.get(1))) return false;
        if (!selection.get(1).equals(selection.get(2))) return false;
        winningMark = selection.get(0);
        return true;
    }

    private List<List<Marks>> rows() {
        List<Marks> top = getSelection(0, 1, 2);
        List<Marks> middle = getSelection(3, 4, 5);
        List<Marks> bottom = getSelection(6, 7, 8);
        return Arrays.asList(top, middle, bottom);
    }

    private List<List<Marks>> columns() {
        List<Marks> left = getSelection(0, 3, 6);
        List<Marks> middle = getSelection(1, 4, 7);
        List<Marks> right = getSelection(2, 5, 8);
        return Arrays.asList(left, middle, right);
    }

    private List<List<Marks>> diagonals() {
        List<Marks> left = getSelection(0, 4, 8);
        List<Marks> right = getSelection(2, 4, 6);
        return Arrays.asList(left, right);
    }
}
