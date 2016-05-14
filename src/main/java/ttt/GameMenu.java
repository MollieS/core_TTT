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

    public List<Player> createPlayers(String gameChoice) {
        int choice = (Integer.parseInt(gameChoice) - 1);
        List<Player> players = PlayerFactory.create(gameOptions.get(choice));
        return players;
    }

    public GameEngine createGame() {
        openMenu();
        String choice = loopForValidInput(input.get());
        List<Player> players = createPlayers(choice);
        Board board = new Board();
        GameEngine gameEngine = new GameEngine(players.get(0), players.get(1), board);
        display.displayMarks(gameEngine.currentPlayer.getMark(), gameEngine.nextPlayer.getMark());
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
        try {
            int type = Integer.parseInt(input);
            return gameOptions.contains(type);

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
