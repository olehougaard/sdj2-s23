package dk.via.objectstream;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        MathClient client = new MathClientImplementation("localhost", 8888);
        System.out.println(client.plus(2, 2));
        client.close();
    }
}
