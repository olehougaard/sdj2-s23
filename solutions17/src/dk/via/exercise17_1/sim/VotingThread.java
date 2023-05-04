package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.voting.Voter;

import java.util.Random;

public class VotingThread extends Thread {
    private final Voter voter;

    public VotingThread(ElectionAccessManager accessManager, String county) {
        voter = new Voter(accessManager, county);
    }

    private void vote() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(random.nextInt(10_000));
        voter.vote();
    }

    @Override
    public void run() {
        try {
            vote();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
