import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Test
    public void hasASymbol() {
        Player player = new HumanPlayer("X");
        assertEquals("X", player.getMark());
    }
}
