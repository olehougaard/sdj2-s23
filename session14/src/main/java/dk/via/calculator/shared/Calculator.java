package dk.via.calculator.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    double plus(double operand1, double operand2) throws RemoteException;

    double minus(double operand1, double operand2) throws RemoteException;

    double times(double operand1, double operand2) throws RemoteException;

    double divide(double operand1, double operand2) throws RemoteException;
}
