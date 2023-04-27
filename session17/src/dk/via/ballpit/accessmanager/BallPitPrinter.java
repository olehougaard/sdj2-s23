package dk.via.ballpit.accessmanager;

import dk.via.ballpit.ReadOnlyBallPit;

public class BallPitPrinter implements Runnable {
    private final AccessManager accessManager;
    private boolean running;

    public BallPitPrinter(AccessManager accessManager) {
        this.accessManager = accessManager;
        this.running = true;
    }

    public void run() {
        while(running) {
            try {
                ReadOnlyBallPit ballPit = accessManager.requestRead();
                System.out.println("Red balls:\t" + ballPit.getRedBalls());
                System.out.println("Green balls:\t" + ballPit.getGreenBalls());
                System.out.println("Total:\t" + ballPit.getTotal());
                System.out.println();
                running = ballPit.getGreenBalls() > 0;
            } finally {
                accessManager.releaseRead();
            }
        }
    }
}
