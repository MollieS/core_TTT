package ttt;

public class HumanPlayer implements Player {

    private String mark;

    public HumanPlayer(String mark) {
        this.mark = mark;
    }

    public String getMark() {
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
