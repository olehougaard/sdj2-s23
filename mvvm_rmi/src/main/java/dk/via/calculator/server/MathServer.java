package dk.via.calculator.server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer {
    public static void main(String[] args) throws IOException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        RemoteCalculator calculator = new RemoteCalculator();
        Remote remote = UnicastRemoteObject.exportObject(calculator, 0);
        registry.bind("calculator", remote);
        System.out.println("Server running");
    }
}
