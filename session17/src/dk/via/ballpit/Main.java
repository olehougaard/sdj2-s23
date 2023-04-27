package dk.via.ballpit;

import dk.via.ballpit.accessmanager.AccessManager;
import dk.via.ballpit.accessmanager.ReaderPreferredAccessManager;
import dk.via.ballpit.accessmanager.WriterPreferredAccessManager;

public class Main {
	public static void main(String[] args) {
		BallPit pit = new UnsafeBallPit(20);
		BallPit safePit = new SynchronizedBallPit(pit);
		Thread writerThread = new Thread(new BallPitPainter(safePit));
		Thread readerThread = new Thread(new BallPitPrinter(safePit));
		writerThread.start();
		readerThread.start();
	}
}
