package dk.via.exercise4_3;

public class Referee {
    public Referee(SoccerMatch match) {
        match.addPropertyChangeListener("OldBoysRoughTackles", evt -> System.out.println("Old Boys yellow card"));
        match.addPropertyChangeListener("DreamTeamRoughTackles", evt -> System.out.println("Dream Team yellow card"));
    }
}
