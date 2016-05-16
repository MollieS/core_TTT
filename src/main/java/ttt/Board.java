package ttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private String[] grid = new String[9];
    private String status;
    private String emptyCell;
    private String winningMark;

    public Board() {
        this.emptyCell = " ";
        this.winningMark = null;
        for (int cell = 0; cell < 9; cell++) {
            grid[cell] = emptyCell;
        }
    }

    public void placeMark(String symbol, int location) {
        grid[location] = symbol;
    }

    public String getStatus() {
        return status;
    }

    public int size() {
        return grid.length;
    }

    public String get(int cell) {
        return grid[cell];
    }

    public String getWinningMark() {
        return winningMark;
    }

    public boolean isAWinFor(String mark) {
        return isWon() && winningMark.equals(mark);
    }

    public void clear(int location) {
        grid[location] = emptyCell;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int cell = 0; cell < grid.length; cell++) {
            if (grid[cell].equals(emptyCell)) {
                moves.add(cell);
            }
        }
        return moves;
    }

    public List<List<String>> winningPositions() {
        List<List<String>> positions = new ArrayList<>();
        positions.addAll(rows());
        positions.addAll(columns());
        positions.addAll(diagonals());
        return positions;
    }


    public boolean isFull() {
        for (String cell : grid) {
            if (cell.equals(emptyCell)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (String cell : grid) {
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
        for (List<String> selection : winningPositions()) {
            if (isAWin(selection)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getCollection(int first, int middle, int last) {
        return Arrays.asList(grid[first], grid[middle], grid[last]);
    }

    private boolean isValidLocation(int location) {
        return (location <= 8 && location >= 0);
    }

    private boolean isCellTaken(int location) {
        return (!grid[location].equals(emptyCell));
    }

    private boolean isAWin(List<String> selection) {
        if (selection.get(0).equals(emptyCell)) return false;
        if (!selection.get(0).equals(selection.get(1))) return false;
        if (!selection.get(1).equals(selection.get(2))) return false;
        winningMark = selection.get(0);
        return true;
    }

    private List<List<String>> rows() {
        List<String> top = getCollection(0, 1, 2);
        List<String> middle = getCollection(3, 4, 5);
        List<String> bottom = getCollection(6, 7, 8);
        return Arrays.asList(top, middle, bottom);
    }

    private List<List<String>> columns() {
        List<String> left = getCollection(0, 3, 6);
        List<String> middle = getCollection(1, 4, 7);
        List<String> right = getCollection(2, 5, 8);
        return Arrays.asList(left, middle, right);
    }

    private List<List<String>> diagonals() {
        List<String> left = getCollection(0, 4, 8);
        List<String> right = getCollection(2, 4, 6);
        return Arrays.asList(left, right);
    }
}
