package solutions2_5;

public class Program implements Runnable {
    private final String program;
    private final String action;
    private final int count;
    private static final long RUNTIME = 100_000;

    public Program(String program, String action, int count) {
        this.program = program;
        this.action = action;
        this.count = count;
    }

    public void run() {
        long delay = RUNTIME / count;
        for(int i = 0; i < count; i++) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                // continue
            }
            System.out.println(program + " wants to " + action);
        }
    }
}
