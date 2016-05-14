package ttt;

public interface Display {

    void write(String output);

    void draw();

    void promptForLocation();

    void invalidLocation();

    void invalidInput();

    void takenCell();

    void displayTurn(String mark);

    void greet();

    void displayMarks(String mark1, String mark2);

    String currentMark(String mark);

    void gameOptions();

    void clearScreen();

}
