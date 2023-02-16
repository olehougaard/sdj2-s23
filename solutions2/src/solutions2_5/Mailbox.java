package solutions2_5;

public class Mailbox implements Runnable {
    private final int count;
    private static final long RUNTIME = 100_000;

    public Mailbox(int count) {
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
            System.out.println("New mail in your mailbox...");
        }
    }
}
