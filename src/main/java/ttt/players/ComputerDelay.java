package ttt.players;

public class ComputerDelay implements Delay {

    public Integer delayMove(Integer move) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            assert false;
        }
        return move;
    }
}
