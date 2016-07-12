package ttt.game;

import ttt.Display;
import ttt.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMenu {

    final private Input input;
    final private Display display;
    final private List<Integer> gameOptions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    final private List<Integer> boardOptions = Arrays.asList(1, 2);
    private List<Integer> playerChoices;

    public GameMenu(Input input, Display display) {
        this.input = input;
        this.display = display;
        this.playerChoices = new ArrayList<>();
    }

    public GameEngine createGame() {
        openGameMenu();
        playerChoices.add(getGameChoice());
        openBoardMenu();
        playerChoices.add(getBoardChoice());
        GameEngine gameEngine = GameConstructor.create(playerChoices, input);
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

    private int loopForValidInput(Integer userInput, List<Integer> options) {
        while (userInput == null) {
            display.clearScreen();
            showCorrectMenu();
            display.invalidInput();
            userInput = input.getMenuChoice(options);
        }
        return userInput;
    }

    private void showCorrectMenu() {
        if (playerChoices.isEmpty()) {
            display.gameOptions();
        } else {
            display.boardOptions();
        }
    }
}
