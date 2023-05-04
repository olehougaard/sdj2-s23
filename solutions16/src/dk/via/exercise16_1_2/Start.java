package dk.via.exercise16_1_2;

public class Start {
    public static void main(String[] args) {
        CarrotBucket queue = new CarrotBucket();
        new Thread(new CarrotPeeler(queue)).start();
        for(int i = 0; i < 5; i++) {
            new Thread(new CarrotEater(queue)).start();
        }
    }
}
