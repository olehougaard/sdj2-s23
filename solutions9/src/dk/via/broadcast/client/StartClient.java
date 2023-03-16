package dk.via.broadcast.client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        LoginClient client = new LoginClientImplementation("localhost", 8080, "230.0.0.0", 8888);
        client.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue());
            }
        });
        System.out.println(client.login("me", "abcd1234"));
        Thread.sleep(10_000);
        client.close();
    }
}
