package dk.via.broadcast.model;

public class Expression {
    private final String operator;
    private final double operand1;
    private final double operand2;

    public Expression(String operator, double operand1, double operand2) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    @Override
    public String toString() {
        return String.format("%f %s %f", operand1, operator, operand2);
    }
}
