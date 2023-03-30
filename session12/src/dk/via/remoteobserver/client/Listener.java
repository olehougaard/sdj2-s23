package dk.via.remoteobserver.client;

import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remoteobserver.shared.Expression;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Step 1: implements RemotePropertyChangeListener<Expression>
// Step 3b: extend UnicastRemoteObject
public class Listener extends UnicastRemoteObject implements RemotePropertyChangeListener<Expression> {
    protected Listener() throws RemoteException {
    }

    @Override
    // Step 2
    public void propertyChange(RemotePropertyChangeEvent<Expression> remotePropertyChangeEvent) throws RemoteException {
        System.out.println("Server received " + remotePropertyChangeEvent.getNewValue());
    }
}
