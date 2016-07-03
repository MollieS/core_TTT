package ttt.players;

import ttt.consoleui.ConsoleInput;
import ttt.game.Marks;
import ttt.Player;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {


    public static List<Player> create(int type, int boardSize) {
        Player player1;
        Player player2;
        if (type == 1) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput(), boardSize);
            player2 = new HumanPlayer(Marks.O, new ConsoleInput(), boardSize);
        } else if (type == 2) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput(), boardSize);
            player2 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.O));
        } else if (type == 3) {
            player1 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
            player2 = new HumanPlayer(Marks.O, new ConsoleInput(), boardSize);
        } else if (type == 4) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput(), boardSize);
            player2 = new DelayedPlayer(new PerfectPlayer(Marks.O));
        } else if (type == 5) {
            player1 = new DelayedPlayer(new PerfectPlayer(Marks.X));
            player2 = new HumanPlayer(Marks.O, new ConsoleInput(), boardSize);
        } else if (type == 6) {
            player1 = new DelayedPlayer(new PerfectPlayer(Marks.X));
            player2 = new DelayedPlayer(new PerfectPlayer(Marks.O));
        } else if (type == 7) {
            player1 = new DelayedPlayer(new PerfectPlayer(Marks.X));
            player2 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.O));
        } else if (type == 8) {
            player1 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
            player2 = new DelayedPlayer(new PerfectPlayer(Marks.O));
        } else {
            player1 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.X));
            player2 = new DelayedPlayer(new RandomPlayer(new RandomLocationGenerator(), Marks.O));
        }
        return Arrays.asList(player1, player2);
    }
}
