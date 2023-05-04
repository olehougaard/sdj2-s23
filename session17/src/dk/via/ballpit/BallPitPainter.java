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
                Thread.sleep(0, 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            running = ballPit.getGreenBalls() > 0;
        }
    }
}
