package dk.via.exercise17_1.voting;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;

public class LocalNews implements Reporter {
    private final ElectionAccessManager accessManager;
    private final String county;

    public LocalNews(ElectionAccessManager accessManager, String county) {
        this.accessManager = accessManager;
        this.county = county;
    }

    public boolean report() {
        Election election = accessManager.requestRead();
        try {
            for(String candidate: Election.CANDIDATES) {
                int votes = election.getNumberOfVotesForCandidateInCounty(candidate, county);
                String voteReport = String.format("%d votes for %s in %s", votes, candidate, county);
                System.out.println(voteReport);
            }
            System.out.println();
            return election.isOpen();
        } finally {
            accessManager.releaseRead();
        }
    }
}
