package ttt;

import org.junit.Before;
import org.junit.Test;
import ttt.game.Board;
import ttt.game.Marks;
import ttt.players.ComputerPlayer;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {

    private Input input = new InputFake();
    private Board board = new Board(3, new Marks[0]);
    private ComputerPlayer computer;

    @Before
    public void setUp() {
        this.computer = new ComputerPlayer(new FakeRandomizer(), Marks.X);
    }

    @Test
    public void returnsARandomLocation() {
        assertEquals("1", computer.getLocation(board));
    }

    @Test
    public void hasMark() {
        assertEquals(computer.getMark(), Marks.X);
    }
}
