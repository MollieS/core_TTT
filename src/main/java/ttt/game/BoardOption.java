package ttt.game;

public enum BoardOption implements Options {

    SMALL ("3", "3x3"),
    BIG ("4", "4x4");

    public String title;
    public String key;

    BoardOption(String key, String name) {
        this.key = key;
        this.title = name;
    }
}
