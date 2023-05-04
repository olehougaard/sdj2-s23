package dk.via.exercise17_1.election;

import java.util.ArrayList;

public class Election {
    public static final String[] CANDIDATES = {"Bozo", "Suit", "Flake"};
    public static final String[] COUNTIES = {"Here", "There", "Everywhere"};

    private final ArrayList<Vote> votes;
    private boolean isOpen;

    public Election() {
        this.votes = new ArrayList<>();
        isOpen = true;
    }

    public void addVote(Vote vote) {
        if (!isOpen) {
            throw new IllegalStateException("Election is closed");
        }
        votes.add(vote);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void close() {
        isOpen = false;
    }

    public int getNumberOfVotesForCandidate(String candidate) {
        return (int) votes.stream()
            .map(Vote::candidate)
            .filter(candidate::equals)
            .count();
    }

    public int getNumberOfVotesForCandidateInCounty(String candidate, String county) {
        return (int) votes.stream()
            .filter(v -> v.candidate().equals(candidate))
            .filter(v -> v.county().equals(county))
            .count();
    }
}
