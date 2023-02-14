package solution1_8;

public class Race {
    private int tortoiseDistance;
    private int hareDistance;

    public Race() {
        tortoiseDistance = 0;
        hareDistance = 0;
    }

    public void moveTortoise() {
        tortoiseDistance++;
    }

    public void moveHare() {
        hareDistance++;
    }

    public int getTortoiseDistance() {
        return tortoiseDistance;
    }

    public int getHareDistance() {
        return hareDistance;
    }

    private boolean tortoiseWon() {
        return tortoiseDistance >= 1000;
    }

    private boolean hareWon() {
        return hareDistance >= 1000;
    }

    public boolean isFinished() {
        return tortoiseWon() || hareWon();
    }

    public String getWinner() {
        if (tortoiseWon()) {
            return "Tortoise";
        } else if (hareWon()) {
            return "Hare";
        } else {
            return null;
        }
    }
}
