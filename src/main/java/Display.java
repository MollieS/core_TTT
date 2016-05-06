public interface Display {

    void write(String output);

    default void board(Game game) {
        String rows = "";
        rows += firstRow();
        rows = drawBoard(rows, game);
        rows += lastRow();
        write(rows);
    }

    default String firstRow() {
        return "-------------\n";
    }

    default String lastRow() {
        return "|\n-------------";
    }

    default String drawBoard(String rows, Game game) {
        for (int cell = 0; cell < 9; cell++) {
            if (isEndOfRow(cell)) {
                rows += "|\n-------------\n";
            }
            rows += "| " + game.board(cell) + " ";
        }
        return rows;
    }

    default boolean isEndOfRow(int cell) {
        return cell % 3 == 0 && cell != 0;
    }

    void draw();

    void promptForLocation();

    void invalidLocation();

    void invalidInput();

    void takenCell();

    void displayTurn(Game game);

    void greet();

    void displayMarks(String mark1, String mark2);

    String currentMark(Game game);

    void gameOptions();
}
