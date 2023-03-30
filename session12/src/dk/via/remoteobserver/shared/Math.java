package dk.via.remoteobserver.shared;

import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Math extends Remote {
    // Step 3
    void addPropertyChangeListener(RemotePropertyChangeListener<Expression> listener) throws RemoteException;
    // Step 3
    void removePropertyChangeListener(RemotePropertyChangeListener<Expression> listener) throws RemoteException;
    double compute(Expression e) throws RemoteException;
}
