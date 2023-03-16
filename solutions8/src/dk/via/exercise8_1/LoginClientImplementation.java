package dk.via.login;

import java.io.*;
import java.net.Socket;

public class LoginClientImplementation implements LoginClient {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public LoginClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.writer = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        writer.println("connect");
        writer.flush();
        String firstReply = reader.readLine();
        if (!firstReply.equals("Username?")) {
            throw new IOException("Protocol error");
        }
        writer.println(username);
        writer.flush();
        String secondReply = reader.readLine();
        if (!secondReply.equals("Password?")) {
            throw new IOException("Protocol error");
        }
        writer.println(password);
        writer.flush();
        return reader.readLine().equals("Approved");
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
