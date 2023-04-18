package dk.via.calculator.server;

import dk.via.calculator.shared.Calculator;

import java.rmi.RemoteException;

public class RemoteCalculator implements Calculator {
    @Override
    public double plus(double operand1, double operand2) throws RemoteException {
        return operand1 + operand2;
    }

    @Override
    public double minus(double operand1, double operand2) throws RemoteException {
        return operand1 - operand2;
    }

    @Override
    public double times(double operand1, double operand2) throws RemoteException {
        return operand1 * operand2;
    }

    @Override
    public double divide(double operand1, double operand2) throws RemoteException {
        return operand1 / operand2;
    }
}
