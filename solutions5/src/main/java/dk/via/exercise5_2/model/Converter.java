package dk.via.exercise5_2.model;

import java.util.ArrayList;

public class Converter {
    private ArrayList<String> history = new ArrayList<>();

    public String toUpperCase(String txt) {
        if (txt == null || txt.isEmpty()) {
            throw new IllegalArgumentException("Source text is empty");
        }
        history.add(txt);
        return txt.toUpperCase();
    }

    public String toLowerCase(String txt) {
        if (txt == null || txt.isEmpty()) {
            throw new IllegalArgumentException("Source text is empty");
        }
        history.add(txt);
        return txt.toLowerCase();
    }

    public String[] getHistory() {
        return history.toArray(String[]::new);
    }
}
