package dk.via.traffic;

public class Car {
    private boolean isRunning;
    private final String license;

    public Car(String license) {
        this.license = license;
        this.isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            System.out.println(license + " starting");
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            System.out.println(license + " stopping");
            isRunning = false;
        }
    }

    public void decelerate() {
        if (isRunning) {
            System.out.println(license + " decelerating");
        }
    }

    public void accelerate() {
        if (isRunning) {
            System.out.println(license + " accelerating");
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public String getLicense() {
        return license;
    }
}
