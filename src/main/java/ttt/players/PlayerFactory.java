package ttt.players;

import ttt.consoleui.ConsoleInput;
import ttt.game.Marks;
import ttt.Player;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {


    public static List<Player> create(int type) {
        Player player1;
        Player player2;
        if (type == 1) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput());
            player2 = new HumanPlayer(Marks.O, new ConsoleInput());
        } else if (type == 2) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput());
            player2 = new ComputerPlayer(new RandomLocationGenerator(), Marks.O);
        } else if (type == 3) {
            player1 = new ComputerPlayer(new RandomLocationGenerator(), Marks.X);
            player2 = new HumanPlayer(Marks.O, new ConsoleInput());
        } else if (type == 4) {
            player1 = new HumanPlayer(Marks.X, new ConsoleInput());
            player2 = new PerfectPlayer(Marks.O);
        } else {
            player1 = new PerfectPlayer(Marks.X);
            player2 = new HumanPlayer(Marks.O, new ConsoleInput());
        }
        return Arrays.asList(player1, player2);
    }
}
