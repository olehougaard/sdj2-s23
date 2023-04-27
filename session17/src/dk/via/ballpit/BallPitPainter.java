package dk.via.ballpit;

public class BallPitPainter implements Runnable {
    private final BallPit ballPit;
    private boolean running;

    public BallPitPainter(BallPit ballPit) {
        this.ballPit = ballPit;
        this.running = true;
    }

    public void run() {
        while(running) {
            ballPit.paintBallRed();
            try {
                //noinspection BusyWait
                Thread.sleep(0, 10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            running = ballPit.getGreenBalls() > 0;
        }
    }
}
