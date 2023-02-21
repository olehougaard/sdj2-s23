package dk.via.exercise4_3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch {
	private final PropertyChangeSupport support;
	private final String team0 = "Dream Team";
	private final String team1 = "Old Boys";
	private int roughTackles0 = 0;
	private int roughTackles1 = 0;
	private int score0 = 0;
	private int score1 = 0;

	public SoccerMatch() {
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		support.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		support.removePropertyChangeListener(propertyName, listener);
	}

	public int getScore0() {
		return score0;
	}

	public int getScore1() {
		return score1;
	}

	public void startMatch() {
		System.out.println("Match starting \n\n");
		Random random = new Random();
		for(int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if(rand < 8) {
				// score goal
				scoreGoal(whichTeam);
			} else if(rand < 12) {
				// penalty
				roughTackle(whichTeam);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		if(whichTeam == 0) {
			int oldValue = roughTackles0;
			roughTackles0++;
			support.firePropertyChange("DreamTeamRoughTackles", oldValue, roughTackles0);
		} else {
			int oldValue = roughTackles1;
			roughTackles1++;
			support.firePropertyChange("OldBoysRoughTackles", oldValue, roughTackles1);
		}
	}

	private void scoreGoal(int whichTeam) {
		if(whichTeam == 0) {
			int oldValue = score0;
			score0++;
			support.firePropertyChange("DreamTeamScore", oldValue, score0);
		} else {
			int oldValue = score1;
			score1++;
			support.firePropertyChange("OldBoysScore", oldValue, score1);
		}
	}
}
