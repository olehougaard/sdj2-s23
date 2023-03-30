package dk.via.exercise11_1.uppercase.client;

import dk.via.exercise11_1.uppercase.server.Uppercase;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // Cast to interface not server class
        Uppercase client = (Uppercase) registry.lookup("uppercase");
        String upper = client.uppercase("hello");
        System.out.println(upper);
    }
}
