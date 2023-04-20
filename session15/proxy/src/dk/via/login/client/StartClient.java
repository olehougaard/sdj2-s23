package dk.via.login.client;

import dk.via.login.shared.Login;

import java.io.IOException;
import java.rmi.NotBoundException;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Login client = new LoginClientImplementation("localhost", 8888);
        System.out.println(client.login("Administrator", "abcd1234"));
    }
}
