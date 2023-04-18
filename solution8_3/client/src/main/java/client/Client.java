package client;

import java.io.Closeable;
import java.io.IOException;

public interface Client extends Closeable {
    String convert(String source) throws IOException;
}
