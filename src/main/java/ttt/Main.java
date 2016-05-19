package ttt;

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
