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
        if (duration > 1000) {
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
