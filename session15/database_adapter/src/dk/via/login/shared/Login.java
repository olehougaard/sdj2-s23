package dk.via.login.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Login extends Remote {
    boolean login(String username, String password) throws RemoteException;

    User createUser(String username, String password, String name) throws RemoteException;

    void updatePassword(String username, String password) throws RemoteException;
}
