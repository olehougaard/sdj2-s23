package solution1_4;

public class Characters implements Runnable {
    private final int iterations;

    public Characters(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for(int i = 0; i < iterations; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c);
            }
        }
    }
}
