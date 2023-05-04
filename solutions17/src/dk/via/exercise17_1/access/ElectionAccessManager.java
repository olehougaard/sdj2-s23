package dk.via.exercise17_1.access;

import dk.via.exercise17_1.election.Election;

public class ElectionAccessManager {
    private final Election election;
    private int readers;
    private int writers;
    private int current;
    private int next;

    public ElectionAccessManager(Election election) {
        this.election = election;
        readers = 0;
        writers = 0;
        current = 0;
        next = 0;
    }

    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    public synchronized Election requestRead() {
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
        return election;
    }

    public synchronized void releaseWrite() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }

    public synchronized Election requestWrite() {
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
        current++;
        if (election.isOpen()) {
            writers++;
            return election;
        } else {
            return null;
        }
    }
}
