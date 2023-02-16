package dk.via.traffic.trafficlight;

import java.util.HashMap;

public class Lights {
    public static final String RED = "Red";
    public static final String YELLOW = "Yellow";
    public static final String GREEN = "Green";

    private final HashMap<String, Boolean> states;

    public Lights() {
        states = new HashMap<>();
        states.put(RED, false);
        states.put(YELLOW, false);
        states.put(GREEN, false);
    }

    private String lightString(String light) {
        if (states.get(light)) {
            return "on";
        } else {
            return "off";
        }
    }

    private void printLight(String light) {
        System.out.println(getStatus(light));
    }

    private String getStatus(String light) {
        return light + " " + lightString(light);
    }

    public String getStatus() {
        return getStatus(RED) + getStatus(YELLOW) + getStatus(GREEN);
    }

    public boolean isTurnedOn(String light) {
        return states.get(light);
    }

    public void printLights() {
        printLight(RED);
        printLight(YELLOW);
        printLight(GREEN);
        System.out.println();
    }

    public void turnOn(String... lights) {
        for(String light: lights) {
            states.put(light, true);
        }
    }

    public void turnOff(String... lights) {
        for(String light: lights) {
            states.put(light, false);
        }
    }
}
