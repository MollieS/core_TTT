package ttt.game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    final private List<Marks> board;
    final private int size;

    public Board(int size, List<Marks> moves) {
        this.size = size;
        int boardSize = (size * size);
        if (moves.size() == 0) {
            this.board = createEmptyBoard(boardSize);
        } else {
            this.board = moves;
        }
    }

    public final Board placeMark(Marks mark, int location) {
        List<Marks> newBoard = createNewBoard(mark, location);
        return new Board(size, newBoard);
    }

    public final int size() {
        return board.size();
    }

    public Marks getMarkAt(int cell) {
        return board.get(cell);
    }

    public List<Integer> availableMoves() {
        List<Integer> moves = IntStream.range(0, board.size())
                .filter(index -> board.get(index) == Marks.CLEAR)
                .mapToObj(index -> index)
                .collect(Collectors.toList());
        return moves;
    }

    public boolean isFull() {
        return board.stream().allMatch(cell -> cell != Marks.CLEAR);
    }

    public boolean isEmpty() {
        return board.stream().allMatch(cell -> cell == Marks.CLEAR);
    }

    public boolean isDraw() {
        return isFull() && !isWon();
    }

    public boolean isFinished() {
        return isDraw() || isWon();
    }

    public boolean isAWinFor(Marks mark) {
        for (List<Marks> cells : winningPositions()) {
            if (isAllTheSame(mark, cells)) {
                return true;
            }
        }
        return false;
    }

    public boolean isWon() {
        for (List<Marks> cells : winningPositions()) {
            if (isAllTheSame(Marks.O, cells) || isAllTheSame(Marks.X, cells)) {
                return true;
            }
        }
        return false;
    }

    public List<List<Marks>> winningPositions() {
        List<List<Marks>> positions = rows();
        positions.addAll(columns());
        positions.addAll(diagonals());
        return positions;
    }

    public List<List<Marks>> getRows() {
        return rows();
    }


    private List<List<Marks>> rows() {
        int rowStart = 0;
        List<List<Marks>> rows = new ArrayList<>();
        for (int cell = 0; cell < size; cell++) {
            List<Marks> cells = new ArrayList<>();
            for (int currentCell = 0; currentCell < size; currentCell++) {
                cells.add(board.get(currentCell + rowStart));
            }
            rows.add(cells);
            rowStart += size;
        }
        return rows;
    }

    private List<List<Marks>> columns() {
        int columnStart = 0;
        List<List<Marks>> columns = new ArrayList<>();
        for (int cell = 0; cell < size; cell++) {
            List<Marks> cells = new ArrayList<>();
            for (int currentCell = columnStart; currentCell < size(); currentCell += size) {
                cells.add(board.get(currentCell));
            }
            columns.add(cells);
            columnStart++;
        }
        return columns;
    }

    private List<List<Marks>> diagonals() {
        List<Marks> left = leftDiagonal();
        List<Marks> right = rightDiagonal();
        return Arrays.asList(left, right);
    }

    private List<Marks> leftDiagonal() {
        List<Marks> left = new ArrayList<>();
        for (int cell = 0; cell < size(); cell += (size + 1)) {
            left.add(board.get(cell));
        }
        return left;
    }

    public List<Marks> rightDiagonal() {
        List<Marks> right = new ArrayList<>();
        for (int cell = (size - 1); cell < (size() - 1); cell += (size - 1)) {
            right.add(board.get(cell));
        }
        return right;
    }

    private boolean isAllTheSame(Marks mark, List<Marks> cells) {
        return Collections.frequency(cells, mark) == size;
    }

    public int dimensions() {
        return size;
    }

    private List<Marks> createEmptyBoard(int boardSize) {
        List<Marks> marks = new ArrayList<>();
        for (int cell = 0; cell < boardSize; cell++) {
            marks.add(cell, Marks.CLEAR);
        }
        return marks;
    }

    private List<Marks> createNewBoard(Marks mark, int location) {
        List<Marks> newBoard = new ArrayList<>(board);
        newBoard.set(location, mark);
        return newBoard;
    }
}
