package solution1_7;

public class TimedPrinter implements Runnable {
    private final int count;

    public TimedPrinter(int count) {
        this.count = count;
    }

    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }
}
