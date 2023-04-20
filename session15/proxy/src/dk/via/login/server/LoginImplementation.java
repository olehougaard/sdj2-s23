package dk.via.login.server;

import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginImplementation extends UnicastRemoteObject implements Login {
    private final UserStorage storage;

    public LoginImplementation(UserStorage storage) throws RemoteException {
        this.storage = storage;
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        User user = storage.getUser(username);
        return password.equals(user.getPassword());
    }

    @Override
    public User createUser(String username, String password, String name) throws RemoteException {
        User user = new User(username, password, name);
        storage.storeUser(user);
        return user;
    }

    @Override
    public void updatePassword(String username, String password) throws RemoteException {
        User user = storage.getUser(username);
        user.setPassword(password);
        storage.storeUser(user);
    }
}
