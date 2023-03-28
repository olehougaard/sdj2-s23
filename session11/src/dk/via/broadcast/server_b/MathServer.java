package dk.via.broadcast.server_b;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer {
    public static void main(String[] args) throws IOException, AlreadyBoundException {
        // Step 1: Start the registry
        Registry registry = LocateRegistry.createRegistry(1099);
        // Step 2: Create the remote object
        MathImplementation math = new MathImplementation();
        // Step 3: Using method (b), so nothing here
        // Step 4: Register the stub
        registry.bind("math", math);
        System.out.println("Server is running");
    }
}
