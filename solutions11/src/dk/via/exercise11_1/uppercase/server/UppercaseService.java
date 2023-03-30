package dk.via.exercise11_1.uppercase.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class UppercaseService extends UnicastRemoteObject implements Uppercase {
    protected UppercaseService() throws RemoteException {
    }

    @Override
    public String uppercase(String source) {
        return source.toUpperCase(Locale.ROOT);
    }
}
