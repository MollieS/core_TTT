package ttt;

public class DisplayFake implements Display {
    private String stream = "";

    public String currentMark(String mark) {
        return mark;
    }

    public void takenCell() {
        write("Already taken");
    }

    public void displayTurn(String mark) {
        write(mark + "'s turn: choose a location");
    }

    public void write(String message) {
        stream += message;
    }

    public String read() {
        return stream;
    }

    public void promptForLocation() {
        write("Please choose a location from 1 to 9");
    }

    public void invalidLocation() {
        write("Invalid location");
    }

    public void invalidInput() {
        write("Please choose a valid option");
    }

    public void draw() {
        write("It's a draw!");
    }

    public void greet() {
        write("Welcome to Tic Tac Toe");
    }

    public void displayMarks(String mark1, String mark2) {
        write("Player One's mark is " + mark1);
        write("Player Two's mark is " + mark2);
    }

    public void gameOptions() {
        write("Please choose your opponent:");
        write("1. Human");
        write("2. Computer");
    }

    public void clearScreen() {

    }
}
