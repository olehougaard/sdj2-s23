package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;

public class FairAccessManager implements AccessManager {
    private final BallPit ballPit;
    private int readers;
    private int writers;
    private int current;
    private int next;

    public FairAccessManager(BallPit ballPit) {
        this.ballPit = ballPit;
        this.readers = 0;
        this.writers = 0;
        this.current = 0;
        this.next = 0;
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
        int myNumber = next;
        next++;
        while(myNumber != current) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(writers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
        current++;
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
        int myNumber = next;
        next++;
        while(myNumber != current) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(writers > 0 || readers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writers++;
        current++;
        return ballPit;
    }
}
