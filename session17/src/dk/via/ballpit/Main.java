package dk.via.ballpit;

import dk.via.ballpit.accessmanager.AccessManager;
import dk.via.ballpit.accessmanager.ReaderPreferredAccessManager;
import dk.via.ballpit.accessmanager.WriterPreferredAccessManager;

public class Main {
	public static void main(String[] args) {
		BallPit pit = new UnsafeBallPit(20);
		BallPit safePit = new SynchronizedBallPit(pit);
		AccessManager manager = new WriterPreferredAccessManager(pit);
		Thread writerThread = new Thread(new dk.via.ballpit.accessmanager.BallPitPainter(manager));
		Thread readerThread = new Thread(new dk.via.ballpit.accessmanager.BallPitPrinter(manager));
		writerThread.start();
		readerThread.start();
	}
}
