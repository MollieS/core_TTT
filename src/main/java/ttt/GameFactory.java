package ttt;

import java.util.List;

public class GameFactory {

    public static GameEngine create(int type) {
        Board board = new Board();
        List<Player> playerList = PlayerFactory.create(type);
        return new GameEngine(playerList.get(0), playerList.get(1), board);
    }
}
