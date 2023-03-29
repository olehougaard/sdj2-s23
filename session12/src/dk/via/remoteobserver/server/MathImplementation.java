package dk.via.remoteobserver.server;

import dk.via.remoteobserver.shared.Expression;
import dk.via.remoteobserver.shared.MathClient;

import java.rmi.RemoteException;

public class MathImplementation implements MathClient {

    @Override
    public double compute(Expression e) throws RemoteException {
        return switch(e.getOperator()) {
            case '+' -> e.getOperand1() + e.getOperand2();
            case '-' -> e.getOperand1() - e.getOperand2();
            case '*' -> e.getOperand1() * e.getOperand2();
            case '/' -> e.getOperand1() / e.getOperand2();
            default -> throw new RemoteException("Unknown operator: " + e.getOperator());
        };
    }
}
