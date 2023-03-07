package dk.via.echo;

import java.io.IOException;

public interface EchoClient {
    String echo(String message) throws IOException;

    void close() throws IOException;
}
