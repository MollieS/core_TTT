package ttt;

public class ConsoleBoard {

    public String createBoard(Board gameBoard) {
        if (gameBoard.size() == 16) {
            return bigBoard(gameBoard);
        }
        return smallBoard(gameBoard);
    }

    private String smallBoard(Board gameBoard) {
        String board = firstRow();
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                board += "|\n-------------\n";
            }
            board += "|" + cellContents(gameBoard, cell) + " ";
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

    private boolean isEndOfBigRow(int cell) {
        return cell % 4 == 0 && cell != 0;
    }

    private String cellContents(Board board, int location) {
        if (board.getMarkAt(location).equals(Marks.CLEAR))
            if (location < 9) {
                return " " + String.valueOf((location + 1));
            } else {
                return String.valueOf(location + 1);
            }
        return " " + board.getMarkAt(location).toString();
    }

    private String bigFirstRow() {
        return ("---------------------\n");
    }

    private String bigLastRow() {
        return ("|\n--------------------");
    }

    private String bigBoard(Board gameBoard) {
        String board = bigFirstRow();
        for (int cell = 0; cell < gameBoard.size(); cell++) {
            if (isEndOfBigRow(cell)) {
                board += "|\n---------------------\n";
            }
            board += "| " + cellContents(gameBoard, cell) + " ";
        }
        board += bigLastRow();
        return board;
    }

}
