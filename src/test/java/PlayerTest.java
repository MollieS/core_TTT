import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void hasASymbol() {
        Player player = new Player("X");
        assertEquals("X", player.getMark());
    }
}
