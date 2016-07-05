package ttt.players;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class DelayedPlayer implements Player {

    private Player player;
    private Integer delay;

    public DelayedPlayer(RandomPlayer player) {
        this.player = player;
        this.delay = 1000;
    }

    public DelayedPlayer(PerfectPlayer player) {
        this.player = player;
        this.delay = 0;
    }

    public Marks getMark() {
        return player.getMark();
    }

    public Integer getLocation(Board board) throws Exception {
        Integer location = player.getLocation(board);
        setDelay(board);
        delayResponse();
        return location;
    }

    private void setDelay(Board board) {
        if (board.availableMoves().size() > 8) {
            this.delay = 1000;
        }
    }

    private void delayResponse() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            assert false;
        }
    }

    public Integer getDelay() {
        return delay;
    }

    public Class<? extends Player> playerType() {
        return player.getClass();
    }
}
