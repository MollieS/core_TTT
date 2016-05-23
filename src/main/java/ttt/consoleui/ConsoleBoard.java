package ttt.consoleui;

import ttt.game.Board;
import ttt.game.Marks;

public class ConsoleBoard {

    public String createBoard(Board gameBoard) {
        return board(gameBoard);
    }

    private String board(Board gameBoard) {
        String board = firstRow(gameBoard.dimensions());
        for (int cell = 0; cell < gameBoard.size(); cell++) {
            if (isEndOfRow(cell, gameBoard)) {
                board += dividingRow(gameBoard.dimensions());
            }
            board += cellDivider(gameBoard.dimensions()) + cellContents(gameBoard, cell) + " ";
        }
        board += lastRow(gameBoard.dimensions());
        return board;
    }

    private String cellDivider(int dimensions) {
        if (dimensions == 3) { return "|"; }
        return "| ";
    }

    private String dividingRow(int dimensions) {
        if (dimensions == 3) { return "|\n-------------\n"; }
        return "|\n---------------------\n";
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

    private boolean isEndOfRow(int cell, Board board) {
        return cell % board.dimensions() == 0 && cell != 0;
    }

    private String firstRow(int dimensions) {
        if (dimensions == 3) { return "-------------\n"; }
        return ("---------------------\n");
    }

    private String lastRow(int dimensions) {
        if (dimensions == 3) { return "|\n-------------"; }
        return ("|\n---------------------");
    }
}
