package dk.via.exercise12_1.client;

import dk.via.exercise12_1.shared.Login;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        Login login = (Login) registry.lookup("login");
        CallbackClient client = new CallbackClient(login);
        System.out.println(client.login("Administrator", "abcd1234"));
    }
}
