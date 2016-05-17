package ttt;

public class HumanPlayer implements Player {

    private Marks mark;

    public HumanPlayer(Marks mark) {
        this.mark = mark;
    }

    public Marks getMark() {
        return mark;
    }

    public String getLocation(Input input, Board board) {
        return formatLocation(input);
    }

    private String formatLocation(Input input) {
        int location = Integer.parseInt((input.get()));
        return String.valueOf(location - 1);
    }
}
