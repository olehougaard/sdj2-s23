package dk.via.runnable;

public class Numbers implements Runnable {
    public Numbers() {
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
