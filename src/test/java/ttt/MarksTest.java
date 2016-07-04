package ttt;

import org.junit.Test;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;

public class MarksTest {

    @Test
    public void hasX() {
        assertEquals(Marks.X, Marks.valueOf("X"));
    }

    @Test
    public void hasO() {
        assertEquals(Marks.O, Marks.valueOf("O"));
    }

    @Test
    public void hasClear() {
        assertEquals(Marks.NULL, Marks.valueOf("NULL"));
    }

    @Test
    public void has3Values() {
        assertEquals(3, Marks.values().length);
    }
}
