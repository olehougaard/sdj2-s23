package solutions2_1;

public class Counter {
    // Critical resource
    private int count;

    public Counter() {
        this.count = 0;
    }

    public synchronized void incrementCount() {
        // Critical region
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
