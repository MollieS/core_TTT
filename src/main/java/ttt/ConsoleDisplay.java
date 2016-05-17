package ttt;

public class ConsoleDisplay implements Display {

    public void gameOptions() {
        write("How would you like to play?");
        write("1. Human v Human");
        write("2. Human v Random Computer");
        write("3. Random Computer v Human");
        write("4. Human v Perfect Computer");
        write("5. Perfect Computer v Human");
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void takenCell() {
        write("Already taken");
    }

    public void invalidLocation() {
        write("Invalid location");
    }

    public void invalidInput() {
        write("Please choose a valid option");
    }

    public void displayTurn(Marks mark) {
        write(mark + "'s turn: choose a location");
    }

    public void promptForLocation() {
        write("Please choose a location from 1 to 9");
    }

    public void draw() {
        write("It's a draw!");
    }

    public String currentMark(Marks mark) {
        return mark.toString();
    }

    public void greet() {
        write("Welcome to Tic Tac Toe");
    }

    public void displayMarks(Marks mark1, Marks mark2) {
        write("Player Two's mark is " + mark2);
        write("Player One's mark is " + mark1);
    }

    public void clearScreen() {
        write("\033[H\033[2J");
        System.out.flush();
    }

    public void winner(Marks mark) {
        write(mark + " wins!");
    }
}
