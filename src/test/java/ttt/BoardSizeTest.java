package ttt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ttt.game.Board;
import ttt.game.Marks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BoardSizeTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                { 3, 9 }, { 4, 16 }
        });
    }

    private int size;
    private int numberOfCells;

    public BoardSizeTest(int input, int expected) {
        this.size = input;
        this.numberOfCells = expected;
    }

    @Test
    public void hasASize() {
        Board board = new Board(size, new ArrayList<>());
        assertEquals(numberOfCells, board.size());
    }
}
