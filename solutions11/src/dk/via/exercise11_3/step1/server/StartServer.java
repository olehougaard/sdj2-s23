package dk.via.exercise11_3.step1.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        dk.via.exercise11_3.step1.server.RmiServer rmiServer = new dk.via.exercise11_3.step1.server.RmiServer();
        Remote remote = UnicastRemoteObject.exportObject(rmiServer, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("remoteMessageList", remote);
        System.out.println("Server running");
    }
}
