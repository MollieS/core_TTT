import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public String[] grid = new String[9];

    public Board() {
        for (int cell = 0; cell < 9; cell++) {
            grid[cell] = " ";
        }
    }

    public String display() {
        String rows = "";
        rows += firstRow();
        rows = getCells(rows);
        rows += lastRow();
        return rows;
    }

    public void placeMark(String symbol, int location) {
        grid[location] = symbol;
    }

    public List<List<String>> winningPositions() {
        List<List<String>> positions = new ArrayList<>();
        positions.addAll(getRows());
        positions.addAll(getColumns());
        positions.addAll(getDiagonals());
        return positions;
    }

    public List<List<String>> rows() {
        return getRows();
    }

    public List<List<String>> columns() {
        return getColumns();
    }

    public List<List<String>> diagonals() {
        return getDiagonals();
    }

    private List<List<String>> getDiagonals() {
        List<String> left = row(0, 4, 8);
        List<String> right = row(2, 4, 6);
        return Arrays.asList(left, right);
    }

    private List<List<String>> getRows() {
        List<String> top = row(0, 1, 2);
        List<String> middle = row(3, 4, 5);
        List<String> bottom = row(6, 7, 8);
        return Arrays.asList(top, middle, bottom);
    }

    private List<List<String>> getColumns() {
        List<String> left = row(0, 3, 6);
        List<String> middle = row(1, 4, 7);
        List<String> right = row(2, 5, 8);
        return Arrays.asList(left, middle, right);
    }

    private String getCells(String rows) {
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                rows += "|\n-------------\n";
            }
            rows += "| " + grid[cell] + " ";
        }
        return rows;
    }

    private boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }

    private String lastRow() {
        return "|\n-------------";
    }

    private String firstRow() {
        return "-------------\n";
    }

    private List<String> row(int first, int middle, int last) {
        return Arrays.asList(grid[first], grid[middle], grid[last]);
    }

    public boolean full() {
        for (int cell = 0; cell < grid.length; cell ++) {
            if (grid[cell] == " ") {
                return false;
            }
        }
        return true;
    }
}
