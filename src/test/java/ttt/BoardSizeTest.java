package ttt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import ttt.game.Board;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BoardSizeTest {

    @Test
    @Parameters({"3, 9"})
    public void hasASize(int size, int numberOfCells) {
        Board board = new Board(size);
        assertEquals(numberOfCells, board.size());
    }
}
