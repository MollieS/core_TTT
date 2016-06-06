package ttt.consoleui;

import ttt.game.Board;
import ttt.game.Marks;

import java.util.List;

public class ConsoleBoard {

    public String createBoard(Board gameBoard) {
        return newBoard(gameBoard);
    }

    private String newBoard(Board gameBoard) {
        String board = "";
        int counter = 1;
        for (List<Marks> row : gameBoard.getRows()) {
            board += rowDivisor(gameBoard) + "\n" + "|";
            for (int cell = 0; cell < row.size(); cell++) {
                board += " " + newCellContents(gameBoard, counter) + "|";
                counter++;
            }
            board += "\n";
        }
        board += rowDivisor(gameBoard);
        return board;
    }

    private String rowDivisor(Board gameBoard) {
        String divisor = "";
        for (int length = 0; length < ((4 * gameBoard.dimensions()) + 1); length++) {
            divisor += "-";
        }
        return divisor;
    }


    private String newCellContents(Board board, int location) {
        if (board.getMarkAt((location - 1)) == Marks.NULL) {
            return getNumber(location);
        } else {
            return board.getMarkAt(location - 1).toString() + " ";
        }
    }

    private String getNumber(int location) {
        if (location + 1 > 10) {
            return String.valueOf(location);
        } else {
            return String.valueOf(location) + " ";
        }
    }

}
