package dk.via.udp;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        UppercaseClient client = new UppercaseClientImplementation("10.154.144.46", 8888);
        System.out.println(client.uppercase("Hello"));
        System.out.println(client.uppercase("Goodbye"));
        client.close();
    }
}
