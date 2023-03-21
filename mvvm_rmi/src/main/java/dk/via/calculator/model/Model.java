package dk.via.calculator.model;

import java.beans.PropertyChangeListener;
import java.io.IOException;

public interface Model {
    double add(double a, double b) throws IOException;

    double subtract(double a, double b) throws IOException;

    double multiply(double a, double b) throws IOException;

    double divide(double a, double b) throws IOException;
}
