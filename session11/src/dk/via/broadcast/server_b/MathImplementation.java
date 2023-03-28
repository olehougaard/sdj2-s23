package dk.via.broadcast.server_b;

import dk.via.broadcast.client.MathClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathImplementation extends UnicastRemoteObject implements MathClient {
    public MathImplementation() throws RemoteException {
    }

    @Override
    public double plus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    public double minus(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
