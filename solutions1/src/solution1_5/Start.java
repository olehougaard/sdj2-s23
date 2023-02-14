package solution1_5;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        PrintNumbers print0 = new PrintNumbers(0, 25000);
        PrintNumbers print25000 = new PrintNumbers(25000, 50000);
        PrintNumbers print50000 = new PrintNumbers(50000, 75000);
        PrintNumbers print75000 = new PrintNumbers(75000, 100000);
        Thread thread0 = new Thread(print0);
        Thread thread25000 = new Thread(print25000);
        Thread thread50000 = new Thread(print50000);
        Thread thread75000 = new Thread(print75000);

        thread0.start();
        thread0.join();
        thread25000.start();
        thread25000.join();
        thread50000.start();
        thread50000.join();
        thread75000.start();
    }
}
