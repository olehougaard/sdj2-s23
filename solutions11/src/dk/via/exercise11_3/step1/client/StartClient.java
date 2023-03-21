package dk.via.exercise11_3.step1.client;

import dk.via.exercise11_3.step1.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        RemoteMessageList remoteMessageList = (RemoteMessageList) registry.lookup("remoteMessageList");
        remoteMessageList.addMessage("Hello");
    }
}
