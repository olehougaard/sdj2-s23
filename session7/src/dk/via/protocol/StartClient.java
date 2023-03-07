package dk.via.protocol;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClientImplementation("localhost", 8888);
        System.out.println(client.echo("Hello"));
        System.out.println(client.uppercase("Goodbye"));
        System.out.println(client.echo("exit"));
        System.out.println(client.echo("echo"));
        client.close();
    }
}
