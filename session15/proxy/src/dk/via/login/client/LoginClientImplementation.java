package dk.via.login.client;

import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginClientImplementation implements Login {
    private final Login login;

    public LoginClientImplementation(String host, int port) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        login = (Login) registry.lookup("login");
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        return login.login(username, password);
    }

    @Override
    public User createUser(String username, String password, String name) throws RemoteException {
        return login.createUser(username, password, name);
    }

    @Override
    public void updatePassword(String username, String password) throws RemoteException {
        login.updatePassword(username, password);
    }
}
