package dk.via.session5.exercise5_3.viewmodel;

import dk.via.session5.exercise5_3.model.Model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

public class CalculatorViewModel {
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
        double sum = model.add(a, b);
        result.set(String.format("%f + %f = %f", a, b, sum));
        error.set("");
    }

    public void subtract() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        double difference = model.subtract(a, b);
        result.set(String.format("%f - %f = %f", a, b, difference));
        error.set("");
    }

    public void multiply() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        double product = model.multiply(a, b);
        result.set(String.format("%f * %f = %f", a, b, product));
        error.set("");
    }

    public void divide() {
        double a = firstOperand.get();
        double b = secondOperand.get();
        double quotient = model.divide(a, b);
        if (Double.isFinite(quotient)) {
            result.set(String.format("%f / %f = %f", a, b, quotient));
            error.set("");
        } else {
            result.set("");
            error.set("Division by zero"); // The only way to get "Not a Number"
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
}
