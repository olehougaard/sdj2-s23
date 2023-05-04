package dk.via.ballpit;

public class SynchronizedBallPit implements BallPit {
    private final BallPit ballPit;

    public SynchronizedBallPit(BallPit ballPit) {
        this.ballPit = ballPit;
    }

    @Override
    public synchronized void paintBallGreen() {
        ballPit.paintBallGreen();
    }

    @Override
    public synchronized void paintBallRed() {
        ballPit.paintBallRed();
    }

    @Override
    public synchronized int getGreenBalls() {
        return ballPit.getGreenBalls();
    }

    @Override
    public synchronized int getRedBalls() {
        return ballPit.getRedBalls();
    }

    @Override
    public synchronized int getTotal() {
        return ballPit.getTotal();
    }
}
