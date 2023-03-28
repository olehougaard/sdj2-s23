package dk.via.broadcast.server_a;

import dk.via.broadcast.client.MathClient;

import java.rmi.RemoteException;

public class MathImplementation implements MathClient {

    @Override
    public double plus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    public double minus(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
