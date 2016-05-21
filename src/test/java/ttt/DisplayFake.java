package ttt;

public class DisplayFake implements Display {
    private String stream = "";

    public String currentMark(Marks mark) {
        return mark.toString();
    }

    public void takenCell() {
        write("Already taken");
    }

    public void displayTurn(Marks mark) {
        write(mark.toString() + "'s turn: choose a location");
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

    public void displayMarks(Marks mark1, Marks mark2) {
        write("Player One's mark is " + mark1.toString());
        write("Player Two's mark is " + mark2.toString());
    }

    public void gameOptions() {
        write("Please choose your opponent:");
        write("1. Human");
        write("2. Computer");
    }

    public void clearScreen() {

    }

    public void winner(Marks mark) {
        write(mark + " wins!");
    }

    public void replay() {
        write("Would you like to play again?");
    }

    public void goodbye() {
        write("Thanks for playing!");
    }
}
