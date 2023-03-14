package dk.via.broadcast.model;

public class Result {
    private final double value;
    private final Expression expression;

    public Result(double value, Expression expression) {
        this.value = value;
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression + " = " + value;
    }
}
