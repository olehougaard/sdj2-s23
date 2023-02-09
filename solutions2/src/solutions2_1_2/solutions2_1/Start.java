package solutions2_1_2.solutions2_1;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        DookuIncrementer incrementer1 = new DookuIncrementer(counter);
        DraculaIncrementer incrementer2 = new DraculaIncrementer(counter);
        DookuIncrementer incrementer3 = new DookuIncrementer(counter);
        DraculaIncrementer incrementer4 = new DraculaIncrementer(counter);

        Thread thread1 = new Thread(incrementer1);
        Thread thread2 = new Thread(incrementer2);
        Thread thread3 = new Thread(incrementer3);
        Thread thread4 = new Thread(incrementer4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(counter.getCountDooku());
        System.out.println(counter.getCountDracula());
    }
}
