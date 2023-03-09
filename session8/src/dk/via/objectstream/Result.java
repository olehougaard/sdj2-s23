package dk.via.objectstream;

import java.io.Serializable;

public class Result implements Serializable {
    private final double value;

    public Result(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
