package dk.via.login;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        LoginClient client = new LoginClientImplementation("localhost", 8888);
        System.out.println(client.login("Administrator", "abcd1234"));
        client.close();
    }
}
