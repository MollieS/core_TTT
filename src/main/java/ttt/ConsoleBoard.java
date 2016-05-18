package ttt;

public class ConsoleBoard {

    private String board;

    public ConsoleBoard() {
        String rows = firstRow();
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                rows += "|\n-------------\n";
            }
            rows += "| " + String.valueOf((cell + 1)) + " ";
        }
        rows += lastRow();
        this.board = rows;
    }

    public String show() {
        return board;
    }

    private String firstRow() {
        return "-------------\n";
    }

    private String lastRow() {
        return "|\n-------------";
    }

    public String update(Marks mark, int location) {
        String number = String.valueOf((location + 1));
        this.board = board.replace(number, mark.toString());
        return board;
    }

    private boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }
}
