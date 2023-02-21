package dk.via.exercise4_3;

public class Medic {
    public Medic(SoccerMatch match) {
        match.addPropertyChangeListener("DreamTeamRoughTackles", evt -> System.out.println("Patching up an Old Boys player"));
        match.addPropertyChangeListener("OldBoysRoughTackles", evt -> System.out.println("Patching up an Dream Team player"));
    }
}
