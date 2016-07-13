package ttt;

import ttt.game.BoardOption;
import ttt.game.GameOption;
import ttt.game.Marks;

public interface Display {

    void write(String output);

    void draw();

    void promptForLocation(int boardSize);

    void invalidInput();

    void displayTurn(Marks mark);

    void greet();

    void displayMarks(Marks mark1, Marks mark2);

    String currentMark(Marks mark);

    void gameOptions(GameOption[] option);

    void clearScreen();

    void winner(Marks x);

    void replay();

    void goodbye();

    void boardOptions(BoardOption[] option);
}
