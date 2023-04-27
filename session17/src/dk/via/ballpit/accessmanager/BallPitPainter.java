package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;

public class BallPitPainter implements Runnable {
    private final AccessManager accessManager;
    private boolean running;

    public BallPitPainter(AccessManager accessManager) {
        this.accessManager = accessManager;
        this.running = true;
    }

    public void run() {
        while(running) {
            try {
                BallPit ballPit = accessManager.requestWrite();
                ballPit.paintBallRed();
                running = ballPit.getGreenBalls() > 0;
            } finally {
                accessManager.releaseWrite();
            }
            try {
                //noinspection BusyWait
                Thread.sleep(0, 10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
