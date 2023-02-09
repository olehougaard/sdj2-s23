package dk.via.pi;

import java.math.BigDecimal;

public class PiService {
    private static class PiRunnable implements Runnable {
        private int digits;
        private BigDecimal pi;

        public PiRunnable(int digits) {
            this.digits = digits;
        }

        public void run() {
            pi = Pi.computePi(digits);
            synchronized (this) {
                notifyAll();
            }
        }

        public BigDecimal getPi() {
            return pi;
        }
    }

    private DecimalCache cache;

    public PiService() {
        this.cache = new DecimalCache();
    }

    public void computePi(int digits) {
        if (!cache.contains(digits)) {
            PiRunnable piRunnable = new PiRunnable(digits);
            Thread thread = new Thread(piRunnable);
            thread.start();
            try {
                synchronized(piRunnable) {
                    piRunnable.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cache.put(digits, piRunnable.getPi());
        }
    }

    public BigDecimal getPi(int digits) {
        return cache.get(digits);
    }
}
