public class Main {

    public static void main(String[] args) {
        GameSetup setupgame = new GameSetup(new ActualInput(), new ActualOutput());
        GamePlay gameplay = new GamePlay(setupgame.setUpGame(), new ActualInput(), new ActualOutput());
        gameplay.start();
    }
}
