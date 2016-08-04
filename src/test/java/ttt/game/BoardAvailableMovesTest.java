package ttt.game;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class BoardAvailableMovesTest {

    @Test
    @Parameters({"3, 0, 1, 2, 3, 4, 5, 6, 7, 8", "4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15"})
    public void forAnEmptyBoard(int size, String... expectedPositions) {
        Board board = new Board(size);
        List<Integer> expected = setUpExpectedPositions(expectedPositions);
        assertEquals(expected, board.availableMoves());
    }

    @Test
    @Parameters({"3, 4, 0, 1, 2, 3, 5, 6, 7, 8", "4, 5, 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15"})
    public void forABoardWithAMark(int size, int location, String... expectedPositions) {
        Board board = new Board(size);
        List<Integer> expected = setUpExpectedPositions(expectedPositions);
        board = board.placeMark(Marks.X, location);
        assertEquals(expected, board.availableMoves());
    }

    @Test
    @Parameters({"3, 0, 1, 2, 3, 4, 5, 6, 7, 8", "4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15"})
    public void knowsWhenFull(int size, String...locations) {
        Board board = new Board(size);
        for (int position = 0; position < locations.length; position++) {
            board = board.placeMark(Marks.X, position);
        }
        assertTrue(board.isFull());
    }

    @Test
    @Parameters({"3", "4"})
    public void knowsWhenNotFull(int size) {
        Board board = new Board(size);
        assertFalse(board.isFull());
    }

    private List<Integer> setUpExpectedPositions(String[] expectedPositions) {
        List<Integer> expected = new ArrayList<>();
        for (int cell = 0; cell < expectedPositions.length; cell++) {
            expected.add(Integer.parseInt(expectedPositions[cell]));
        }
        return expected;
    }
}
