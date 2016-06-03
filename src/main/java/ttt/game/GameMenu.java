package ttt.game;

import ttt.Display;
import ttt.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMenu {

    final private Input input;
    final private Display display;
    final private List<Integer> gameOptions = Arrays.asList(1, 2, 3, 4, 5, 6);
    final private List<Integer> boardOptions = Arrays.asList(1, 2);

    public GameMenu(Input input, Display display) {
        this.input = input;
        this.display = display;
    }

    public GameEngine createGame() {
        List<Integer> playerChoices = new ArrayList<>();
        openGameMenu();
        playerChoices.add(getGameChoice());
        openBoardMenu();
        playerChoices.add(getBoardChoice());
        GameEngine gameEngine = GameConstructor.create(playerChoices);
        display.displayMarks(gameEngine.currentMark(), gameEngine.nextMark());
        return gameEngine;
    }

    private int getBoardChoice() {
        return loopForValidInput(input.getMenuChoice(boardOptions), boardOptions);
    }

    private int getGameChoice() {
        return loopForValidInput(input.getMenuChoice(gameOptions), gameOptions);
    }

    private void openGameMenu() {
        display.greet();
        display.gameOptions();
    }

    private void openBoardMenu() {
        display.boardOptions();
    }

    private int loopForValidInput(int userInput, List<Integer> options) {
        while (userInput == 0) {
            display.invalidInput();
            userInput = input.getMenuChoice(options);
        }
        return userInput;
    }
}
