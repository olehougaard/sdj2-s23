package solution1_6;

public class CounterIncrementer implements Runnable {
    private Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 1_000_000; i++) {
            counter.incrementCount();
        }
    }
}
