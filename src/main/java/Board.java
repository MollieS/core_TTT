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

    public String[][] horizontalRows() {
        String[] topRow = row(0, 1, 2);
        String[] middleRow = row(3, 4, 5);
        String[] bottomRow = row(6, 7, 8);
        String[][] rows = {topRow, middleRow, bottomRow};
        return rows;
    }

    public String[][] verticalRows() {
        String[] leftRow = row(0, 3, 6);
        String[] middleRow = row(1, 4, 7);
        String[] rightRow = row(2, 5, 8);
        String[][] rows = {leftRow, middleRow, rightRow};
        return rows;
    }

    public String[][] diagonals() {
        String[] leftDiagonal = row(0, 4, 8);
        String[] rightDiagonal = row(2, 4, 6);
        String[][] diagonals = {leftDiagonal, rightDiagonal};
        return diagonals;
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

    private String[] row(int first, int middle, int last) {
        return new String[]{grid[first], grid[middle], grid[last]};
    }

}
