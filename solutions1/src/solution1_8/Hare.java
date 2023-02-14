package solution1_8;

import java.util.Random;

public class Hare implements Runnable {
    private final Race race;
    private final Random random;

    public Hare(Race race) {
        this.race = race;
        this.random = new Random();
    }

    public void run() {
        while(!race.isFinished()) {
            race.moveHare();
            System.out.println("Hare: " + race.getHareDistance());
            try {
                if (race.getHareDistance() >= race.getTortoiseDistance() + 50) {
                    Thread.sleep(random.nextInt(500) + 500);
                } else {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                // continue
            }
        }
    }
}
