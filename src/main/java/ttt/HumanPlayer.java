package ttt;

public class HumanPlayer implements Player {

    private String mark;

    public HumanPlayer(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public String getLocation(Input inputFeed, Board board) {
        String location = inputFeed.get();
        try {
            return String.valueOf((Integer.parseInt(location) - 1));
        } catch (NumberFormatException e) {
            return "invalid location";
        }
    }
}
