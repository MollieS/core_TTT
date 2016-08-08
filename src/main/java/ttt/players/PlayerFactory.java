package ttt.players;

import ttt.Player;
import ttt.PlayerType;
import ttt.game.Marks;

public abstract class PlayerFactory {

    private static int delay = 1000;
    private static int noDelay = 0;

    public static Player create(String playerType, Marks mark) {
        switch (playerType) {
            case PlayerType.PERFECT:
                return createPerfectPlayer(mark);
            default:
                return createRandomPlayer(mark);
        }
    }

    private static Player createRandomPlayer(Marks mark) {
        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator();
        return new DelayedPlayer(new RandomPlayer(randomLocationGenerator, mark), delay);
    }

    private static Player createPerfectPlayer(Marks mark) {
        return new DelayedPlayer(new PerfectPlayer(mark), noDelay);
    }
}
