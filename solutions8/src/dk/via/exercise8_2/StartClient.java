package dk.via.exercise8_2;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        LoginClient client = new LoginClientImplementation("localhost", 8888);
        System.out.println(client.login("Administrator", "abcd1234"));
        client.close();
    }
}
