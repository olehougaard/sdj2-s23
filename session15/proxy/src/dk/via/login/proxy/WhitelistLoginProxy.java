package dk.via.login.proxy;

import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class WhitelistLoginProxy extends UnicastRemoteObject implements Login {
    private final Login delegate;
    private final Set<String> whitelist;

    public WhitelistLoginProxy(Login delegate) throws RemoteException {
        this.delegate = delegate;
        this.whitelist = new HashSet<>();
    }

    public void permit(String host) {
        whitelist.add(host);
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        try {
            if (!whitelist.contains(getClientHost())) {
                return false;
            }
        } catch (ServerNotActiveException e) {
            throw new RemoteException(e.getMessage(), e);
        }
        return delegate.login(username, password);
    }

    @Override
    public User createUser(String username, String password, String name) throws RemoteException {
        return delegate.createUser(username, password, name);
    }

    @Override
    public void updatePassword(String username, String password) throws RemoteException {
        delegate.updatePassword(username, password);
    }
}
