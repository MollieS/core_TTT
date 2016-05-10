package main;

public class ConsoleBoard {

    private String board;

    public String show() {
        String rows = firstRow();
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                rows += "|\n-------------\n";
            }
            rows += "| " + String.valueOf((cell + 1)) + " ";
        }
        rows += lastRow();
        this.board = rows;
        return rows;
    }

    private String firstRow() {
        return "-------------\n";
    }

    private String lastRow() {
        return "|\n-------------";
    }

    public String update(String mark, int location) {
        String number = String.valueOf((location + 1));
        this.board = board.replace(number, mark);
        return board;
    }

    private boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }
}
