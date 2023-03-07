package dk.via.udp;

import java.io.Closeable;
import java.io.IOException;

public interface UppercaseClient extends Closeable {
    String uppercase(String message) throws IOException;
}
