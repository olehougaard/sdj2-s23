package dk.via.pi;

import java.math.BigDecimal;
import java.util.Random;

public class PiClient implements Runnable {
    private PiService service;

    public PiClient(PiService service) {
        this.service = service;
    }

    public void run() {
        Random random = new Random();
        while(true) {
            int digits = random.nextInt(100_000) + 100_000;
            service.computePi(digits);
            BigDecimal piToDigits = service.getPi(digits);
            System.out.println(piToDigits);
        }
    }
}
