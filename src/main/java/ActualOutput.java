public class ActualOutput implements Outputter {

    public void write(String message) {
        System.out.println(message);
    }

    public String read() {
        return null;
    }
}
