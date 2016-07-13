package ttt.game;

import ttt.BoardDisplay;
import ttt.Display;
import ttt.Input;

import java.util.ArrayList;
import java.util.List;

public class GameMenu {

    final private Input input;
    final private Display display;
    final private GameOption[] gameOptions = GameOption.values();
    final private BoardOption[] boardOptions = BoardOption.values();
    final private String[] replayOptions = {"y", "n"};
    private List<Integer> playerChoices;
    private BoardDisplay boardDisplay;

    public GameMenu(Input input, Display display, BoardDisplay boardDisplay) {
        this.input = input;
        this.display = display;
        this.playerChoices = new ArrayList<>();
        this.boardDisplay = boardDisplay;
    }

    public void start() {
        playGame(createGame());
    }

    public void playGame(GameEngine game) {
        GameLoop loop = new GameLoop(game, display, boardDisplay);
        loop.start();
        GameEngine newGame = askForReplay();
        if (newGame != null) {
            playGame(newGame);
        }
    }

    public GameEngine askForReplay() {
        display.replay();
        GameEngine game = null;
        String replayAnswer = input.getReplay();
        if (replayAnswer.equals("y")) {
            game = createGame();
        } else {
            display.goodbye();
        }
        return game;
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
        return loopForValidBoardChoice(input.getBoardChoice(boardOptions), boardOptions);
    }

    private int getGameChoice() {
        return loopForGameChoice(input.getGameChoice(gameOptions), gameOptions);
    }

    private void openGameMenu() {
        display.greet();
        display.gameOptions(gameOptions);
    }

    private void openBoardMenu() {
        display.boardOptions(boardOptions);
    }

    private int loopForValidBoardChoice(Integer userInput, BoardOption[] options) {
        while (userInput == null) {
            display.clearScreen();
            openBoardMenu();
            display.invalidInput();
            userInput = input.getBoardChoice(options);
        }
        return userInput;
    }

    private int loopForGameChoice(Integer userInput, GameOption[] options) {
        while (userInput == null) {
            display.clearScreen();
            openGameMenu();
            display.invalidInput();
            userInput = input.getGameChoice(options);
        }
        return userInput;
    }


}
