package dk.via.exercise12_1.client;

import dk.via.exercise12_1.shared.Login;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackClient extends UnicastRemoteObject implements RemotePropertyChangeListener<String> {
    private final Login login;

    public CallbackClient(Login login) throws RemoteException {
        this.login = login;
        login.addPropertyChangeListener(this);
    }

    public boolean login(String username, String password) throws RemoteException {
        return login.login(username, password);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent<String> remotePropertyChangeEvent) throws RemoteException {
        System.out.println(remotePropertyChangeEvent.getNewValue());
    }
}
