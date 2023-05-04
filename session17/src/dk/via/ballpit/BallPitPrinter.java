package dk.via.ballpit;

public class BallPitPrinter implements Runnable {
    private final BallPit ballPit;

    public BallPitPrinter(BallPit ballPit) {
        this.ballPit = ballPit;
    }

    public void run() {
        while(true) {
            System.out.println("Red balls:\t" + ballPit.getRedBalls());
            System.out.println("Green balls:\t" + ballPit.getGreenBalls());
            System.out.println("Total:\t" + ballPit.getTotal());
            System.out.println();
            if (ballPit.getGreenBalls() == 0) break;
        }
    }
}
