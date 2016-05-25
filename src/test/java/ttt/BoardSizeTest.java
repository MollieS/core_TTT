package ttt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ttt.game.Board;
import ttt.game.Marks;

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

    private int fInput;
    private int fExpected;

    public BoardSizeTest(int input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void hasASize() {
        Board board = new Board(fInput, new Marks[0]);
        assertEquals(fExpected, board.size());
    }
}
