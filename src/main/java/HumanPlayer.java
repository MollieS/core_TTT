public class HumanPlayer implements Player {

    private String mark;

    public HumanPlayer(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public String getLocation(InputFeed inputFeed, Board board) {
        return inputFeed.get();
    }
}
