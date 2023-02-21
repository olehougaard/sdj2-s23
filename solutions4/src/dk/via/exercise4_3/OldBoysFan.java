package dk.via.exercise4_3;

public class OldBoysFan {
    public OldBoysFan(SoccerMatch match) {
        match.addPropertyChangeListener("OldBoysScore", (e)-> System.out.println("Old Boys fan: GOOOOOOOOOOAL!"));
        match.addPropertyChangeListener("DreamTeamScore", (e)-> System.out.println("Old Boys fan: Booooo"));
    }
}
