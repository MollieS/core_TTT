package ttt;

import ttt.players.Randomizer;

import java.util.List;

public class FakeRandomizer implements Randomizer {

    public Integer location(List<Integer> locations) {
        return 1;
    }
}
