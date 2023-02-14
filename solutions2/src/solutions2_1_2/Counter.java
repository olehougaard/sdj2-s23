package solutions2_1_2;

public class Counter {
    // Critical resource 1
    private int countDooku;
    private int countDracula;

    private final Object lockDooku = new Object();
    private final Object lockDracula = new Object();

    public Counter() {
        this.countDooku = 0;
        this.countDracula = 0;
    }

    public void incrementDooku() {
        // Critical region 1
        synchronized(lockDooku) {
            this.countDooku++;
        }
    }

    public void incrementDracula() {
        // Critical region 2
        synchronized(lockDracula) {
            this.countDracula++;
        }
    }

    public int getCountDooku() {
        return countDooku;
    }

    public int getCountDracula() {
        return countDracula;
    }
}
