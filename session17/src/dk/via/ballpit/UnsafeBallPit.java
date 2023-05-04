package dk.via.ballpit;

public class UnsafeBallPit implements BallPit {
	private int greenBalls;
	private int redBalls;
	
	public UnsafeBallPit(int size) {
		greenBalls = size;
		redBalls = 0;
	}
	
	@Override
	public int getGreenBalls() {
		return greenBalls;
	}
	
	@Override
	public int getRedBalls() {
		return redBalls;
	}
	
	@Override
	public int getTotal() {
		return greenBalls + redBalls;
	}
	
	@Override
	public void paintBallGreen() {
		if (redBalls > 0) {
			greenBalls++;
			redBalls--;
		}
	}
	
	@Override
	public void paintBallRed() {
		if (greenBalls > 0) {
			greenBalls--;
			redBalls++;
		}
	}
}
