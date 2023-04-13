package dk.via.exercise12_1.server;

import dk.via.exercise12_1.shared.Login;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.rmi.RemoteException;

public class LoginImplementation implements Login {
    private final RemotePropertyChangeSupport<String> support;

    public LoginImplementation() {
        support = new RemotePropertyChangeSupport<>();
    }

    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<String> listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        // In real situations: Replace with proper check
        boolean approved = !username.isEmpty() && !password.isEmpty();
        if (approved) {
            support.firePropertyChange("login", null, username);
        }
        return approved;
    }
}
