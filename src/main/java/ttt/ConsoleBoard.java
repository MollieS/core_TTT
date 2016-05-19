package ttt;

public class ConsoleBoard {

    public String createBoard(Board gameBoard) {
        String board = firstRow();
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                board += "|\n-------------\n";
            }
            board += "| " + cellContents(gameBoard.getMarkAt(cell), cell) + " ";
        }
        board += lastRow();
        return board;
    }

    private String firstRow() {
        return "-------------\n";
    }

    private String lastRow() {
        return "|\n-------------";
    }

    private boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }

    private String cellContents(Marks cell, int location) {
        if (cell.equals(Marks.CLEAR)) return String.valueOf((location + 1));
        return cell.toString();
    }
}
