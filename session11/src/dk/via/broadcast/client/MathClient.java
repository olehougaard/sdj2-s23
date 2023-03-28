package dk.via.broadcast.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Step 1: extends Remote
public interface MathClient extends Remote {
    // Step 2: Remember throws RemoteException
    double plus(double operand1, double operand2) throws RemoteException;
    double minus(double operand1, double operand2) throws RemoteException;
}
