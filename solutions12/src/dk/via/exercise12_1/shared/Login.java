package dk.via.exercise12_1.shared;

import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Login extends Remote {
    void addPropertyChangeListener(RemotePropertyChangeListener<String> listener) throws RemoteException;

    boolean login(String username, String password) throws RemoteException;
}
