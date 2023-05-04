package dk.via.exercise17_1.voting;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;

public class News implements Reporter {
    private final ElectionAccessManager accessManager;

    public News(ElectionAccessManager accessManager) {
        this.accessManager = accessManager;
    }

    public boolean report() {
        Election election = accessManager.requestRead();
        try {
            for(String candidate: Election.CANDIDATES) {
                int votes = election.getNumberOfVotesForCandidate(candidate);
                String voteReport = String.format("%d votes for %s", votes, candidate);
                System.out.println(voteReport);
            }
            System.out.println();
            return election.isOpen();
        } finally {
            accessManager.releaseRead();
        }
    }
}
