package dk.via.exercise11_1.uppercase.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UppercaseServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        UppercaseService service = new UppercaseService();
        // Remote object = UnicastRemoteObject.exportObject(service, 8888);
        registry.bind("uppercase", service);
        System.out.println("Server started");
    }
}
