package ttt.players;

import java.util.List;
import java.util.Random;

public class RandomLocationGenerator implements Randomizer {

    public Integer location(List<Integer> locations) {
        Random random = new Random();
        int index = random.nextInt(locations.size());
        return locations.get(index);
    }
}
