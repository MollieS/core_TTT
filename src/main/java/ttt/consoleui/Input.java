package ttt.consoleui;

public interface Input {
    String get();

    boolean validInput(String input);

    String getReplay();
}

