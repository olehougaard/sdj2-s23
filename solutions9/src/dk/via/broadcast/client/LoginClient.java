package dk.via.broadcast.client;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.io.IOException;

public interface LoginClient extends Closeable {
    boolean login(String username, String password) throws IOException;

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
