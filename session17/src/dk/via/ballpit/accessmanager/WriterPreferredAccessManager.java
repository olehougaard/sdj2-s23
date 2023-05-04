package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;

public class WriterPreferredAccessManager implements AccessManager {
    private final BallPit ballPit;
    private int readers;
    private int writers;
    private int writersWaiting;

    public WriterPreferredAccessManager(BallPit ballPit) {
        this.ballPit = ballPit;
        this.readers = 0;
        this.writers = 0;
        this.writersWaiting = 0;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized ReadOnlyBallPit requestRead() {
        while(writers > 0 || writersWaiting > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
        return ballPit;
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized BallPit requestWrite() {
        writersWaiting++;
        while(writers > 0 || readers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writers++;
        writersWaiting--;
        return ballPit;
    }
}
