package dk.via.login.proxy;

import dk.via.log.DefaultLog;
import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoggerProxy extends UnicastRemoteObject implements Login {
    private final Login login;
    private final DefaultLog log;

    public LoggerProxy(Login login) throws RemoteException {
        this.login = login;
        this.log = DefaultLog.getInstance();
    }

    public boolean login(String username, String password) throws RemoteException {
        try {
            log.log(username + " logged in.");
        } catch (IOException e) {
            throw new RemoteException(e.getMessage(), e);
        }
        return login.login(username, password);
    }

    public User createUser(String username, String password, String name) throws RemoteException {
        return login.createUser(username, password, name);
    }

    public void updatePassword(String username, String password) throws RemoteException {
        login.updatePassword(username, password);
    }
}
