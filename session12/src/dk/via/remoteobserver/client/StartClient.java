package dk.via.remoteobserver.client;

import dk.via.remoteobserver.shared.Expression;
import dk.via.remoteobserver.shared.Math;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        Math math = (Math) registry.lookup("math");
        // Step 3
        math.addPropertyChangeListener(new Listener());
        Expression expression = new Expression('+', 2, 2);
        System.out.println(math.compute(expression));
   }
}
