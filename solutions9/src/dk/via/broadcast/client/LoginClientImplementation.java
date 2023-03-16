package dk.via.broadcast.client;

import com.google.gson.Gson;
import dk.via.broadcast.model.Login;
import dk.via.broadcast.model.Result;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;

public class LoginClientImplementation implements LoginClient {
    private static final String EXIT_JSON = """
    {"operator": "exit"}
    """;

    private final Socket socket;
    private final PrintWriter writer;
    private final Gson gson;
    private final PropertyChangeSupport support;
    private final BufferedReader reader;
    private final MessageListener listener;

    public LoginClientImplementation(String host, int port, String groupAddress, int groupPort) throws IOException {
        this.socket = new Socket(host, port);
        this.writer = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.gson = new Gson();
        this.support = new PropertyChangeSupport(this);

        listener = new MessageListener(this, groupAddress, groupPort);
        Thread thread = new Thread(listener);
        thread.start();
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        writer.println("connect");
        writer.flush();
        String firstReply = reader.readLine();
        if (!firstReply.equals("Login required")) {
            throw new IOException("Protocol error");
        }
        Login login = new Login(username, password);
        String loginJson = gson.toJson(login);
        writer.println(loginJson);
        writer.flush();
        String finalReply = reader.readLine();
        return finalReply.equals("Approved");
    }

    @Override
    public void close() throws IOException {
        listener.close();
        writer.println(EXIT_JSON);
        writer.flush();
        socket.close();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void receiveBroadcast(String message) {
        Login login = gson.fromJson(message, Login.class);
        support.firePropertyChange("login", null, login);
    }
}
