package dk.via.exercise17_1.voting;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;
import dk.via.exercise17_1.election.Vote;

import java.util.Random;

public class Voter {
    private final ElectionAccessManager accessManager;
    private final String county;
    private boolean hasVoted;

    public Voter(ElectionAccessManager accessManager, String county) {
        this.accessManager = accessManager;
        this.county = county;
        this.hasVoted = false;
    }

    public void vote() {
        if (!hasVoted) {
            Election election = accessManager.requestWrite();
            try {
                if (election == null) {
                    return;
                }
                Random random = new Random();
                String candidate = Election.CANDIDATES[random.nextInt(Election.CANDIDATES.length)];
                election.addVote(new Vote(candidate, county));
                hasVoted = true;
            } finally {
                accessManager.releaseWrite();
            }
        }
    }
}
