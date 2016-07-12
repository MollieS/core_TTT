package ttt.players;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class DelayedPlayer implements Player {

    private Player player;
    private Integer delay;

    public DelayedPlayer(Player player, int delay) {
        this.player = player;
        this.delay = delay;
    }

    public Marks getMark() {
        return player.getMark();
    }

    public int getLocation(Board board) throws Exception {
        int location = player.getLocation(board);
        setDelay(board);
        delayResponse();
        return location;
    }

    private void setDelay(Board board) {
        if (board.availableMoves().size() < 10) {
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
