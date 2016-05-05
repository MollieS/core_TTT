public class SystemDisplay implements Display {

    public void gameOptions() {
        write("Please choose your opponent:");
        write("1. Human");
        write("2. Computer");
    }

    public void write(String message) {
        System.out.println(message);
    }

    public String read() {
        return null;
    }

    public void takenCell() {
        write("Already taken");
    }

    public void invalidLocation() {
        write("Invalid location");
    }

    public void invalidInput() {
        write("Numbers only");
    }

    public void displayTurn(Game game) {
        write(currentMark(game) + "'s turn: choose a location");
    }

    public void promptForLocation() {
        write("Please choose a location from 1 to 9");
    }

    public void draw() {
        write("It's a draw!");
    }

    public String currentMark(Game game) {
        return game.currentPlayer.getMark();
    }

    public void greet() {
        write("Welcome to Tic Tac Toe");
    }

    public void promptForMark() {
        write("Player One please choose a mark");
        write("X or O");
    }

    public void displayMarks(String mark1, String mark2) {
        write("Player One's mark is " + mark1);
        write("Player Two's mark is " + mark2);
    }

    public void promptForFirstGo() {
        write("Who goes first? X or O");
    }
}
