package solutions2_1_2.solutions2_1;

public class DraculaIncrementer implements Runnable {
    private final Counter counter;

    public DraculaIncrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 1_000_000; i++) {
            counter.incrementDracula();
        }
    }
}
