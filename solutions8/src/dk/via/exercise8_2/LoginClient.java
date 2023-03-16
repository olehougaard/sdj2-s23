package dk.via.exercise8_2;

import java.io.Closeable;
import java.io.IOException;

public interface LoginClient extends Closeable {
    boolean login(String username, String password) throws IOException;
}
