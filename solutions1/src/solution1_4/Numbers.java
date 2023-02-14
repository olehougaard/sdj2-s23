package solution1_4;

public class Numbers implements Runnable {
    private final int iterations;

    public Numbers(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
