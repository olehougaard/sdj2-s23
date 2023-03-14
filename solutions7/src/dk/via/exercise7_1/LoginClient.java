package dk.via.exercise7_1;

import java.io.*;
import java.net.Socket;

public class LoginClient implements Closeable {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public LoginClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.writer = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public boolean login(String username, String password) throws IOException {
        writer.println("connect");
        writer.flush();
        String reply = reader.readLine();
        if (!reply.equals("Username?")) {
            throw new IOException("Protocol failure");
        }
        writer.println(username);
        writer.flush();
        reply = reader.readLine();
        if (!reply.equals("Password?")) {
            throw new IOException("Protocol failure");
        }
        writer.println(password);
        writer.flush();
        reply = reader.readLine();
        return reply.equals("Approved");
    }

    @Override
    public void close() throws IOException {
        writer.println("Disconnect");
        writer.flush();
        String reply = reader.readLine();
        if (!reply.equals("Disconnected")) {
            throw new IOException("Protocol failure");
        }
        socket.close();
    }
}
