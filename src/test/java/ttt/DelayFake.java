package ttt;

import ttt.players.Delay;

public class DelayFake implements Delay {

    public Integer delayMove(Integer move) {
        return move;
    }
}
