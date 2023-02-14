package solution1_2;

import java.math.BigInteger;

public class Timer {
    public static long runAndTime(Runnable runnable) {
        long beforeTime = System.currentTimeMillis();
        runnable.run();
        long afterTime = System.currentTimeMillis();
        return afterTime - beforeTime;
    }

    public static void main(String[] args) {
        long time = runAndTime(() -> {
            BigInteger factorial = BigInteger.valueOf(1);
            for(int i = 1; i < 1_000_000; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
        });
        System.out.println(time);
    }
}
