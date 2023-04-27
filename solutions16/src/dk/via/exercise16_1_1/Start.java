package dk.via.exercise16_1_1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Start {
    public static void main(String[] args) {
        BlockingQueue<Carrot> queue = new ArrayBlockingQueue<>(20);
        new Thread(new CarrotPeeler(queue)).start();
        for(int i = 0; i < 5; i++) {
            new Thread(new CarrotEater(queue)).start();
        }
    }
}
