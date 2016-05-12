package ttt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private String[] grid = new String[9];
    private String status;

    public Board() {
        for (int cell = 0; cell < 9; cell++) {
            grid[cell] = " ";
        }
    }

    public Board dummyBoard() {
        Board dummy = new Board();
        for (int cell = 0; cell < grid.length; cell++) {
            dummy.grid[cell] = grid[cell];
        }
        return dummy;
    }

    public void clear (int location) {
        grid[location] = " ";
    }

    public String get(int cell) {
        return grid[cell];
    }

    public String getStatus() {
        return status;
    }

    public int size() {
        return grid.length;
    }

    public boolean winFor(String mark) {
        List<String> win = Arrays.asList(mark, mark, mark);
        for (int position = 0; position < winningPositions().size(); position++) {
            if(winningPositions().get(position).equals(win)) return true;
        }
        return false;
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int cell = 0; cell < grid.length; cell ++) {
            if (grid[cell].equals(" ")) {
               moves.add(cell);
            }
        }
        return moves;
    }

    public void placeMark(String symbol, int location) {
        if (!validLocation(location)) {
            this.status = "invalid location";
        } else if (cellTaken(location)) {
            this.status = "taken";
        } else {
            grid[location] = symbol;
            status = "mark placed";
        }
    }

    public List<List<String>> winningPositions() {
        List<List<String>> positions = new ArrayList<>();
        positions.addAll(rows());
        positions.addAll(columns());
        positions.addAll(diagonals());
        return positions;
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

    public boolean isFull() {
        return checkEveryCell();
    }

    public boolean isEmpty() {
        for (int cell = 0; cell < grid.length; cell++) {
            if (!grid[cell].contains(" ")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEveryCell() {
        for (int cell = 0; cell < grid.length; cell++) {
            if (grid[cell].contains(" ")) {
                return false;
            }
        }
        return true;
    }

    private List<String> getCollection(int first, int middle, int last) {
        return Arrays.asList(grid[first], grid[middle], grid[last]);
    }

    private boolean validLocation(int location) {
        return (location <= 8 && location >= 0);
    }

    private boolean cellTaken(int location) {
        return (!grid[location].equals(" "));
    }

    public boolean isDraw() {
        return (isFull() && !winFor("X") && !winFor("O"));
    }

    public boolean isFinished() {
        return (isDraw() || winFor("X") || winFor("O"));
    }
}
