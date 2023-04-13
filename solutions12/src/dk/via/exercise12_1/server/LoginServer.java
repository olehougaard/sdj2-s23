package dk.via.exercise12_1.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        LoginImplementation login = new LoginImplementation();
        Remote remote = UnicastRemoteObject.exportObject(login, 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("login", remote);
        System.out.println("Server running");
    }
}
