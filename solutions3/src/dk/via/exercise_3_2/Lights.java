package dk.via.exercise_3_2;

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
        System.out.println(light + " " + lightString(light));
    }

    public void printLights() {
        printLight(RED);
        printLight(YELLOW);
        printLight(GREEN);
        System.out.println();
    }

    public void turnOn(String... lights) {
        for (String light : lights) {
            states.put(light, true);
        }
    }

    public void turnOff(String... lights) {
        for (String light : lights) {
            states.put(light, false);
        }
    }
}
