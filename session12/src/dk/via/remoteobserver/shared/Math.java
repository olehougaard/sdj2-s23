package dk.via.remoteobserver.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Math extends Remote {
    double compute(Expression e) throws RemoteException;
}
