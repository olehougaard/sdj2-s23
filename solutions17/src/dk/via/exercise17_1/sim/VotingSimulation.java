package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;

import java.util.Random;

public class VotingSimulation extends Thread {
    private final ElectionAccessManager accessManager;

    public VotingSimulation(ElectionAccessManager accessManager) {
        this.accessManager = accessManager;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            String county = Election.COUNTIES[random.nextInt(Election.COUNTIES.length)];
            VotingThread voter = new VotingThread(accessManager, county);
            voter.start();
        }
    }
}
