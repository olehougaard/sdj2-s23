package dk.via.exercise4_3;

public class Start {
    public static void main(String[] args) {
        SoccerMatch soccerMatch = new SoccerMatch();
        new OldBoysFan(soccerMatch);
        new DreamTeamFan(soccerMatch);
        new Referee(soccerMatch);
        new AngryCoach(soccerMatch, 0);
        new AngryCoach(soccerMatch, 1);
        new ScoreBoard(soccerMatch);
        new Medic(soccerMatch);
        soccerMatch.startMatch();
    }
}
