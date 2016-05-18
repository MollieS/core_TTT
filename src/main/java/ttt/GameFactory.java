package ttt;

import java.util.List;

public class GameFactory {

    public static GameEngine create(List<Integer> types) {
        Board board;
        if (types.get(1) == 1) {
            board = new Board(3);
        } else {
            board = new Board(4);
        }
        List<Player> playerList = PlayerFactory.create(types.get(0));
        return new GameEngine(playerList.get(0), playerList.get(1), board);
    }
}
