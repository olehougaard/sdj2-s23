package dk.via.broadcast.client;

import dk.via.broadcast.server_a.MathImplementation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        // Step 1: Get the registry
        Registry registry = LocateRegistry.getRegistry(1099);
        // Step 2: Lookup the remote object
        // Step 3: Cast the proxy to the remote interface
        MathClient client = (MathClient) registry.lookup("math");
        System.out.println(client.plus(2, 2));
   }
}
