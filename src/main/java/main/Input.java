package main;

import java.util.Scanner;

public class Input implements InputFeed {

    public String get() {
        Scanner scanner = new Scanner(System.in);
        String stream = scanner.next();
        return stream;
    }

}
