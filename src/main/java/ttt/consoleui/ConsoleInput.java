package ttt.consoleui;

import ttt.Input;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {

    public String getUserChoice() {
        String stream = getInput();
        if (isAnInteger(stream)) { return stream; }
        return "-1";
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public boolean isAnInteger(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        String stream = getInput();
        return stream;
    }

    public int getMenuChoice(List<Integer> options) {
        int choice =  validateChoice();
        if (options.contains(choice)) { return choice; }
        return 0;
    }

    private int validateChoice() {
        String input = getInput();
        int choice;
        if (isAnInteger(input)) {
            choice = Integer.parseInt(input);
        } else {
            choice = 0;
        }
        return choice;
    }

}
