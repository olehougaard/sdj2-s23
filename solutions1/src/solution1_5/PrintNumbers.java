package solution1_5;

public class PrintNumbers implements Runnable {
    private final int x;
    private final int y;

    public PrintNumbers(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void run() {
        for(int i = x; i < y; i++) {
            System.out.println(i);
        }
    }
}
