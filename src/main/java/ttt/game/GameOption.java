package ttt.game;

public enum GameOption {

    HVH ("1", "Human v Human"),
    HVR ("2", "Human v Random Player"),
    RVH ("3", "Random Player v Human"),
    RVR ("4", "Random Player v Random Player"),
    HVP ("5", "Human v Perfect Player"),
    PVH ("6", "Perfect Player v Human"),
    PVP ("7", "Perfect Player v Perfect Player"),
    PVR ("8", "Perfect Player v Random Player"),
    RVP ("9", "Random Player v Perfect Player");

    private String name;
    public String key;

    GameOption(String key, String name) {
        this.key = key;
        this.name = name;
    }

}
