package dk.via.login.server;

import dk.via.login.shared.User;

import java.rmi.RemoteException;

public interface UserStorage {
    User getUser(String username) throws RemoteException;
    void storeUser(User user) throws RemoteException;
}
