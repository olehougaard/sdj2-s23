package dk.via.session5.exercise5_3.model;

public class ModelManager implements Model {
    private final Calculator calculator;

    public ModelManager() {
        this.calculator = new Calculator();
    }

    @Override
    public double add(double a, double b) {
        return calculator.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        return calculator.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        return calculator.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        return calculator.divide(a, b);
    }
}
