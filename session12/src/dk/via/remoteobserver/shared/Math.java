package dk.via.remoteobserver.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathClient extends Remote {
    double compute(Expression e) throws RemoteException;
}
