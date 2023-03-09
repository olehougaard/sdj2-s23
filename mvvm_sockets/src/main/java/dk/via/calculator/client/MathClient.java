package dk.via.calculator.client;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.io.IOException;

public interface MathClient extends Closeable {
    double plus(double operand1, double operand2) throws IOException;

    double minus(double operand1, double operand2) throws IOException;

    double times(double operand1, double operand2) throws IOException;

    double divide(double operand1, double operand2) throws IOException;

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
