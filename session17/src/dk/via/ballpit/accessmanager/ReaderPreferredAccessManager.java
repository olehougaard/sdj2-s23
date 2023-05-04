package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;

public class ReaderPreferredAccessManager implements AccessManager {
    private final BallPit ballPit;
    private int readers;
    private int writers;

    public ReaderPreferredAccessManager(BallPit ballPit) {
        this.ballPit = ballPit;
        this.readers = 0;
        this.writers = 0;
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
        while(writers > 0) {
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
        while(writers > 0 || readers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writers++;
        return ballPit;
    }
}
