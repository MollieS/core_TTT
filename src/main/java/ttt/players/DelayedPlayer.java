package ttt.players;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class DelayedPlayer implements Player {

    private Player player;

    public DelayedPlayer(Player player) {
        this.player = player;
    }

    public Marks getMark() {
        return player.getMark();
    }

    public Integer getLocation(Board board) throws Exception {
        long startTime = System.currentTimeMillis();
        Integer location = player.getLocation(board);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        return delayResponse(location, duration);
    }

    public Integer delayResponse(Integer location, long duration) throws InterruptedException {
        if (duration > 500) {
            return location;
        } else {
            Thread.sleep(1000);
            return location;
        }
    }

    public Class<? extends Player> playerType() {
        return player.getClass();
    }
}
