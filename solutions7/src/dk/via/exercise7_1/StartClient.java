package dk.via.exercise7_1;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        LoginClient client = new LoginClient("localhost", 9999);
        System.out.println(client.login("me", "1234"));
        client.close();
    }
}
