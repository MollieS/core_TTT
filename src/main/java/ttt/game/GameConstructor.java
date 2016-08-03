package ttt.game;

import ttt.Player;
import ttt.players.PlayerFactory;

import java.util.List;

public class GameConstructor {

    final private static int[] boardSizes = {3, 4};

    public static GameEngine create(List<Integer> types, PlayerFactory playerFactory) {
        Board board = createBoard(types);
        List<Player> playerList = playerFactory.create(types.get(0));
        return new GameEngine(playerList.get(0), playerList.get(1), board);
    }

    private static Board createBoard(List<Integer> types) {
        Board board;
        if (types.get(1) == boardSizes[0]) {
            board = new Board(boardSizes[0]);
        } else {
            board = new Board(boardSizes[1]);
        }
        return board;
    }

}
