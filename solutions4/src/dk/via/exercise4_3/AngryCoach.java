package dk.via.exercise4_3;

public class AngryCoach {
    public AngryCoach(SoccerMatch match, int whichTeam) {
        if (whichTeam == 0) {
            match.addPropertyChangeListener("OldBoysRoughTackles", evt -> System.out.println("Dream Team coach yells at ref."));
            match.addPropertyChangeListener("DreamTeamScore", evt -> System.out.println("Dream Team coach cheers."));
        } else {
            match.addPropertyChangeListener("DreamTeamRoughTackles", evt -> System.out.println("Old Boys coach yells at ref."));
            match.addPropertyChangeListener("OldBoysScore", evt -> System.out.println("Old Boys coach cheers."));
        }
    }
}
