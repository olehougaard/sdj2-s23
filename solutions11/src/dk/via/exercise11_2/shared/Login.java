package dk.via.exercise11_2.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Login extends Remote {
    boolean login(String username, String password) throws RemoteException;
}
