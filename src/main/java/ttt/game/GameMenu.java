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
        String boardChoice = loopForValidInput(input.get(), 2);
        return Integer.parseInt(boardChoice);
    }

    private int getGameChoice() {
        String gameChoice = loopForValidInput(input.get(), 1);
        return Integer.parseInt(gameChoice);
    }

    private void openGameMenu() {
        display.greet();
        display.gameOptions();
    }

    private void openBoardMenu() {
        display.boardOptions();
    }

    private String loopForValidInput(String userInput, int type) {
        while (!validInput(userInput, type)) {
            display.invalidInput();
            userInput = input.get();
        }
        return userInput;
    }

    private boolean validInput(String input, int type) {
        int option = Integer.parseInt(input);
        if (type == 1) {
            return gameOptions.contains(option);
        } else {
            return boardOptions.contains(option);
        }
    }
}
