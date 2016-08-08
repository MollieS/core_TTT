package ttt.game;

import ttt.Player;
import ttt.players.PlayerFactory;

public class GameConstructor {

    public static GameEngine create(String firstPlayer, String secondPlayer, int boardSize) {
        Board board = new Board(boardSize);
        Player player1 = PlayerFactory.create(firstPlayer, Marks.X);
        Player player2 = PlayerFactory.create(secondPlayer, Marks.O);
        return new GameEngine(player1, player2, board);
    }

}
