package ttt;

public interface Display {

    void write(String output);

    void draw();

    void promptForLocation();

    void invalidLocation();

    void invalidInput();

    void takenCell();

    void displayTurn(Marks mark);

    void greet();

    void displayMarks(Marks mark1, Marks mark2);

    String currentMark(Marks mark);

    void gameOptions();

    void clearScreen();

}
