package dk.via.calculator.viewmodel;

import dk.via.calculator.model.Model;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class CalculatorViewModel implements PropertyChangeListener {
    private final Model model;
    private final DoubleProperty firstOperand;
    private final DoubleProperty secondOperand;
    private final StringProperty result;
    private final StringProperty error;
    private final NumberStringConverter stringConverter;

    public CalculatorViewModel(Model model) {
        this.model = model;
        this.firstOperand = new SimpleDoubleProperty(0);
        this.secondOperand = new SimpleDoubleProperty(0);
        this.result = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.stringConverter = new NumberStringConverter();
    }

    public void add() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        try {
            double sum = model.add(a, b);
            result.set(String.format("%f + %f = %f", a, b, sum));
            error.set("");
        } catch (IOException e) {
            result.set("");
            error.set("Server communication error");
        }
    }

    public void subtract() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        try {
            double difference = model.subtract(a, b);
            result.set(String.format("%f - %f = %f", a, b, difference));
            error.set("");
        } catch (IOException e) {
            result.set("");
            error.set("Server communication error");
        }
    }

    public void multiply() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        try {
            double product = model.multiply(a, b);
            result.set(String.format("%f * %f = %f", a, b, product));
            error.set("");
        } catch (IOException e) {
            result.set("");
            error.set("Server communication error");
        }
    }

    public void divide() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        try {
            double quotient = model.divide(a, b);
            if (Double.isFinite(quotient)) {
                result.set(String.format("%f / %f = %f", a, b, quotient));
                error.set("");
            } else {
                result.set("");
                error.set("Division by zero"); // The only way to get "Not a Number"
            }
        } catch (IOException e) {
            result.set("");
            error.set("Server communication error");
        }
    }

    public void bindFirst(StringProperty property) {
        property.bindBidirectional(firstOperand, stringConverter);
    }

    public void bindSecond(StringProperty property) {
        property.bindBidirectional(secondOperand, stringConverter);
    }

    public void bindResult(StringProperty property) {
        property.bind(result);
    }

    public void bindError(StringProperty property) {
        property.bind(error);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            result.set("Change happened");
        });
    }
}
