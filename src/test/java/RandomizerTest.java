import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class RandomizerTest {

    @Test
    public void returnsRandomNumberFromList() {
        Randomizer randomizer = new RandomLocationGenerator();
        List<String> locations = Arrays.asList("1", "2", "3");
        assertFalse(randomizer.location(locations).contains("4"));
    }
}
