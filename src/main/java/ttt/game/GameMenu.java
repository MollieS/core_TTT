package ttt.game;

import ttt.BoardDisplay;
import ttt.Display;
import ttt.Input;
import ttt.Player;
import ttt.players.PlayerFactory;

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
    private Player humanPlayer1;
    private Player humanPlayer2;

    public GameMenu(Input input, Display display, BoardDisplay boardDisplay, Player player, Player player2) {
        this.input = input;
        this.display = display;
        this.playerChoices = new ArrayList<>();
        this.boardDisplay = boardDisplay;
        this.humanPlayer1 = player;
        this.humanPlayer2 = player2;
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
            playerChoices = new ArrayList<>();
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
        GameEngine gameEngine = GameConstructor.create(playerChoices, new PlayerFactory(humanPlayer1, humanPlayer2));
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
