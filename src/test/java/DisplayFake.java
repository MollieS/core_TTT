public class DisplayFake implements Display {

    public String currentMark(Game game) {
        return game.currentPlayer.getMark();
    }

    public void takenCell() {
        write("Already taken");
    }

    public void displayTurn(Game game) {
        write(currentMark(game) + "'s turn: choose a location");
    }

    private String stream = "";

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
        write("Numbers only");
    }
    public void draw() {
        write("It's a draw!");
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
