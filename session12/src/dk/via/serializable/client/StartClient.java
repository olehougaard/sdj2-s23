package dk.via.serializable.client;

import dk.via.serializable.shared.Expression;
import dk.via.serializable.shared.MathClient;

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
        Expression expression = new Expression('+', 2, 2);
        System.out.println(client.compute(expression));
   }
}
