package ttt.players;

import ttt.Input;
import ttt.Player;
import ttt.game.Marks;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    public static List<Player> create(int type, int boardSize, Input inputType) {
        Player player1;
        Player player2;
        Input input = inputType;
        if (type == 1) {
            player1 = createHumanPlayer(Marks.X, input, boardSize);
            player2 = createHumanPlayer(Marks.O, input, boardSize);
        } else if (type == 2) {
            player1 = createHumanPlayer(Marks.X, input, boardSize);
            player2 = createRandomPlayer(Marks.O);
        } else if (type == 3) {
            player1 = createRandomPlayer(Marks.X);
            player2 = createHumanPlayer(Marks.O, input, boardSize);
        } else if (type == 4) {
            player1 = createHumanPlayer(Marks.X, input, boardSize);
            player2 = createPerfectPlayer(Marks.O);
        } else if (type == 5) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = createHumanPlayer(Marks.O, input, boardSize);
        } else if (type == 6) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = createPerfectPlayer(Marks.O);
        } else if (type == 7) {
            player1 = createPerfectPlayer(Marks.X);
            player2 = createRandomPlayer(Marks.O);
        } else if (type == 8) {
            player1 = createRandomPlayer(Marks.X);
            player2 = createPerfectPlayer(Marks.O);
        } else {
            player1 = createRandomPlayer(Marks.X);
            player2 = createRandomPlayer(Marks.O);
        }
        return Arrays.asList(player1, player2);
    }

    private static HumanPlayer createHumanPlayer(Marks mark, Input input, int boardsize) {
        return new HumanPlayer(mark, input, boardsize);
    }

    private static Player createRandomPlayer(Marks mark) {
        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator();
        return new DelayedPlayer(new RandomPlayer(randomLocationGenerator, mark));
    }

    private static Player createPerfectPlayer(Marks mark) {
        return new DelayedPlayer(new PerfectPlayer(mark));
    }
}
