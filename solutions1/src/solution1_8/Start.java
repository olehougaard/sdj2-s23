package solution1_8;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Race race = new Race();
        Tortoise tortoise = new Tortoise(race);
        Hare hare = new Hare(race);
        Thread tortoiseThread = new Thread(tortoise);
        Thread hareThread = new Thread(hare);
        tortoiseThread.start();
        hareThread.start();
        tortoiseThread.join();
        hareThread.join();
        System.out.println(race.getWinner());
    }
}
