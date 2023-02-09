package solutions2_1_2.solutions2_1;

public class DookuIncrementer implements Runnable {
    private final Counter counter;

    public DookuIncrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 1_000_000; i++) {
            counter.incrementDooku();
        }
    }
}
