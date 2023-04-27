package dk.via.ballpit;

public class BallPitPrinter implements Runnable {
    private final BallPit ballPit;
    private boolean running;

    public BallPitPrinter(BallPit ballPit) {
        this.ballPit = ballPit;
        this.running = true;
    }

    public void run() {
        while(running) {
            System.out.println("Red balls:\t" + ballPit.getRedBalls());
            System.out.println("Green balls:\t" + ballPit.getGreenBalls());
            System.out.println("Total:\t" + ballPit.getTotal());
            System.out.println();
            running = ballPit.getGreenBalls() > 0;
        }
    }
}
