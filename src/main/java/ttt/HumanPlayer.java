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
        String location = input.get();
        try {
            return String.valueOf((Integer.parseInt(location) - 1));
        } catch (NumberFormatException e) {
            return "-1";
        }
    }
}
