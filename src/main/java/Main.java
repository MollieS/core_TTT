public class Main {

    public static void main(String[] args) {
        SystemDisplay display = new SystemDisplay();
        Input input = new Input();
        GameSetup gameSetup = new GameSetup(input, display);
        GamePlay gameplay = new GamePlay(gameSetup.setUpGame(), input, display);
        gameplay.start();
    }
}
