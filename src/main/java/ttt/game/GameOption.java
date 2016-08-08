package ttt.game;

public enum GameOption {

    HVH ("1", "Human v Human"),
    HVR ("2", "Human v Random"),
    RVH ("3", "Random v Human"),
    RVR ("4", "Random v Random"),
    HVP ("5", "Human v Perfect"),
    PVH ("6", "Perfect v Human"),
    PVP ("7", "Perfect v Perfect"),
    PVR ("8", "Perfect v Random"),
    RVP ("9", "Random v Perfect");

    public String title;
    public String key;

    GameOption(String key, String title) {
        this.key = key;
        this.title = title;
    }

}
