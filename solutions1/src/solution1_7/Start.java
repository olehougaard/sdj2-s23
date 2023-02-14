package solution1_7;

public class Start {
    private static void runWithRunnable() {
        TimedPrinter printer = new TimedPrinter(100);
        Thread thread = new Thread(printer);
        thread.start();
    }

    private static void runWithLambda() {
        Runnable printer = () -> {
            for(int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        Thread thread = new Thread(printer);
        thread.start();
    }

    public static void main(String[] args) {
        runWithRunnable();
        runWithLambda();
    }
}
