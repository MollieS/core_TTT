package main;

public class Main {

    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        ConsoleBoard consoleBoard = new ConsoleBoard();
        ConsoleInput input = new ConsoleInput();
        GameMenu menu = new GameMenu(input, display);
        GamePlay gameplay = new GamePlay(menu.createGame(), input, display, consoleBoard);
        gameplay.start();
    }
}
