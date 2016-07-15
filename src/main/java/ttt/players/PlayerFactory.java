package ttt.players;

import ttt.Player;
import ttt.game.Marks;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    private Player humanplayer1;
    private Player humanplayer2;

    public PlayerFactory(Player player1, Player player2) {
        humanplayer1 = player1;
        humanplayer2 = player2;
    }

    public List<Player> create(int type) {
        Player player1;
        Player player2;
        if (type == 1) {
            player1 = humanplayer1;
            player2 = humanplayer2;
        } else if (type == 2) {
            player1 = humanplayer1;
            player2 = createRandomPlayer(Marks.O);
        } else if (type == 3) {
            player1 = createRandomPlayer(Marks.X);
            player2 = humanplayer2;
        } else if (type == 4) {
            player1 = createRandomPlayer(Marks.X);
            player2 = createRandomPlayer(Marks.O);
        } else if (type == 5) {
            player1 = humanplayer1;
            player2 = createPerfectPlayer(Marks.O);
        } else if (type == 6) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = humanplayer2;
        } else if (type == 7) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = createPerfectPlayer(Marks.O);
        } else if (type == 8) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = createRandomPlayer(Marks.O);
        } else {
            player1 = createRandomPlayer(Marks.X);
            player2 = createPerfectPlayer(Marks.O);
        }
        return Arrays.asList(player1, player2);
    }

    private Player createRandomPlayer(Marks mark) {
        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator();
        return new DelayedPlayer(new RandomPlayer(randomLocationGenerator, mark), 1000);
    }

    private Player createPerfectPlayer(Marks mark) {
        return new DelayedPlayer(new PerfectPlayer(mark), 0);
    }
}
