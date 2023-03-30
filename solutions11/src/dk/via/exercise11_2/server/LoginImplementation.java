package dk.via.exercise11_2.server;

import dk.via.exercise11_2.shared.Login;

import java.rmi.RemoteException;

public class LoginImplementation implements Login {
    @Override
    public boolean login(String username, String password) throws RemoteException {
        // In real situations: Replace with proper check
        return !username.isEmpty() && !password.isEmpty();
    }
}
