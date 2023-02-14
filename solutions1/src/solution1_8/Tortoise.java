package solution1_8;

public class Tortoise implements Runnable {
    private final Race race;

    public Tortoise(Race race) {
        this.race = race;
    }

    public void run() {
        while(!race.isFinished()) {
            race.moveTortoise();
            System.out.println("Tortoise: " + race.getTortoiseDistance());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Continue running
            }
        }
    }
}
