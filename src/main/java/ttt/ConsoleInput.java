package ttt;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String get() {
        Scanner scanner = new Scanner(System.in);
        String stream = scanner.next();
        if (validInput(stream)) { return stream; }
        return "-1";
    }

    public boolean validInput(String input) {
        return input.matches("[0-9]+");
    }

}
