package ttt.game;

import ttt.consoleui.Display;
import ttt.consoleui.Input;
import ttt.game.GameEngine;
import ttt.game.GameFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMenu {

    private Input input;
    private Display display;
    private List<Integer> gameOptions;
    private List<Integer> boardOptions;

    public GameMenu(Input input, Display display) {
        this.input = input;
        this.display = display;
        this.gameOptions = Arrays.asList(1, 2, 3, 4, 5, 6);
        this.boardOptions = Arrays.asList(1, 2);
    }

    public GameEngine createGame() {
        List<Integer> playerChoices = new ArrayList<>();
        openGameMenu();
        playerChoices.add(getGameChoice());
        openBoardMenu();
        playerChoices.add(getBoardChoice());
        GameEngine gameEngine = GameFactory.create(playerChoices);
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
