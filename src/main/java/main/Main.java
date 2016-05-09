package main;

public class Main {

    public static void main(String[] args) {
        SystemDisplay display = new SystemDisplay();
        Input input = new Input();
        GameMenu menu = new GameMenu(input, display);
        GamePlay gameplay = new GamePlay(menu.createGame(), input, display);
        gameplay.start();
    }
}
