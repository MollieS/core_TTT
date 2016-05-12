package ttt;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String get() {
        Scanner scanner = new Scanner(System.in);
        String stream = scanner.next();
        return stream;
    }

    public String markOne() {
       return "X";
    }

    public String markTwo() {
        return "O";
    }
}
