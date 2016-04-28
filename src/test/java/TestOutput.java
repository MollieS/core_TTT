public class TestOutput implements Outputter {

    private String stream;

    public void write(String message) {
        stream += message;
    }

    public String read() {
        return stream;
    }
}
