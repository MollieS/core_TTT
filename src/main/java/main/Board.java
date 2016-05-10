package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private String[] grid = new String[9];

    public Board() {
        for (int cell = 0; cell < 9; cell++) {
            grid[cell] = " ";
        }
    }

    public String get(int cell) {
        return grid[cell];
    }

    public int size() {
        return grid.length;
    }

    public void placeMark(String symbol, int location) {
        if (!validLocation(location)) {
            System.out.println("invalid");
        } else if (cellTaken(location)) {
            System.out.println("taken");
        } else {
            grid[location] = symbol;
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
}
