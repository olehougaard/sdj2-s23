package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.voting.Reporter;

import java.util.Random;

public class NewsThread extends Thread {
    private final Reporter reporter;

    public NewsThread(Reporter reporter) {
        this.reporter = reporter;
    }

    @SuppressWarnings({"BusyWait"})
    @Override
    public void run() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
            while(true) {
                boolean isOpen = reporter.report();
                if (!isOpen) break;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
