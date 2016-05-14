package ttt;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    public enum Marks {
        X ("X"),
        O ("O");

        public final String mark;

        Marks (String mark) {
            this.mark = mark;
        }
    }

    public static List<Player> create(int type) {
        Player player1;
        Player player2;
        if (type == 1 || type == 2) {
            player1 = new HumanPlayer(Marks.X.mark);
            player2 = new HumanPlayer(Marks.O.mark);
            if (type == 2) {
                return Arrays.asList(player2, player1);
            }
        } else if (type == 3){
            player1 = new HumanPlayer(Marks.X.mark);
            player2 = new ComputerPlayer(new RandomLocationGenerator(), Marks.O.mark);
        } else if (type == 4){
            player1 = new ComputerPlayer(new RandomLocationGenerator(), Marks.X.mark);
            player2 = new HumanPlayer(Marks.O.mark);
        } else if (type == 5){
            player1 = new HumanPlayer(Marks.X.mark);
            player2 = new PerfectPlayer(Marks.O.mark);
        } else {
            player1 = new PerfectPlayer(Marks.X.mark);
            player2 = new HumanPlayer(Marks.O.mark);
        }
        return Arrays.asList(player1, player2);
    }
}
