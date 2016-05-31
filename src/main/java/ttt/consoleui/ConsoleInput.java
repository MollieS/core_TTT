package ttt.consoleui;

import ttt.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String get() {
        String stream = getInput();
        if (validInput(stream)) { return stream; }
        return "-1";
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public boolean validInput(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        String stream = getInput();
        return stream;
    }

}
