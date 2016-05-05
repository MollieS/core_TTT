import java.util.Scanner;

public class ActualInput implements Input {

    public String get() {
        Scanner scanner = new Scanner(System.in);
        String stream = scanner.next();
        return stream;
    }

    public void set(String... words) {
    }
}
