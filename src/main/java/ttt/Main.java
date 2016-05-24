package ttt;

import ttt.consoleui.ConsoleBoard;
import ttt.consoleui.ConsoleDisplay;
import ttt.consoleui.ConsoleInput;
import ttt.game.GameLoop;
import ttt.game.GameMenu;

public class Main {

    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        ConsoleBoard consoleBoard = new ConsoleBoard();
        ConsoleInput input = new ConsoleInput();
        GameMenu menu = new GameMenu(input, display);
        GameLoop gameplay = new GameLoop(menu.createGame(), input, display, consoleBoard);
        gameplay.start();
    }
}
