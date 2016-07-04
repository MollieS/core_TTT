package ttt;

public class GameException extends Exception {
    public GameException(String error) {
        super(error);
    }

    public static GameException takenCell() {
        return new GameException("Already taken");
    }

    public static GameException notANumber() {
        return new GameException("Not a number");
    }

    public static GameException outOfBounds() {
        return new GameException("Out of bounds");
    }


}
