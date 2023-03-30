package dk.via.exercise11_2.client;

import dk.via.exercise11_2.shared.Login;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        Login client2 = (Login) registry.lookup("login");
        System.out.println(client2.login("Administrator", "abcd1234"));
    }
}
