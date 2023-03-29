package dk.via.serializable.server;

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
        // Step 3: Create server stub
        Remote stub = UnicastRemoteObject.exportObject(math, 0); // 0: Java figures it out
        // Step 4: Register the stub
        registry.bind("math", stub);
        System.out.println("Server is running");
    }
}
