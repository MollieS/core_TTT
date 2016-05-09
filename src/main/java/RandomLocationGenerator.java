import java.util.List;
import java.util.Random;

public class RandomLocationGenerator implements Randomizer {

    public String location(List<String> locations) {
        Random random = new Random();
        int index = random.nextInt(locations.size());
        return locations.get(index);
    }
}
