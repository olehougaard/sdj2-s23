package dk.via.exercise8_2;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class LoginClientImplementation implements LoginClient {
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

    public LoginClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.output = new ObjectOutputStream(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.input = new ObjectInputStream(inputStream);
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        try {
            output.writeObject("connect");
            output.flush();
            String firstReply = (String) input.readObject();
            if (!firstReply.equals("Login required")) {
                throw new IOException("Protocol error");
            }
            Login login = new Login(username, password);
            output.writeObject(login);
            output.flush();
            return input.readObject().equals("Approved");
        } catch (ClassNotFoundException e) {
            throw new IOException("Wrong client");
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
