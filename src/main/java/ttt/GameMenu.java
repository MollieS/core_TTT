package ttt;

import java.util.Arrays;
import java.util.List;

public class GameMenu {

    private Input input;
    private Display display;
    private List<Integer> gameOptions;

    public GameMenu(Input input, Display display) {
        this.input = input;
        this.display = display;
        this.gameOptions = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    public void show() {
        display.gameOptions();
    }

    public GameEngine createGame() {
        openMenu();
        String choice = loopForValidInput(input.get());
        int formattedChoice = Integer.parseInt(choice);
        GameEngine gameEngine = GameFactory.create(formattedChoice);
        display.displayMarks(gameEngine.currentMark(), gameEngine.nextMark());
        return gameEngine;
    }

    private void openMenu() {
        display.greet();
        display.gameOptions();
    }

    private String loopForValidInput(String userInput) {
        while (!validInput(userInput)) {
            display.invalidInput();
            userInput = input.get();
        }
        return userInput;
    }

    private boolean validInput(String input) {
        int type = Integer.parseInt(input);
        return gameOptions.contains(type);
    }
}
