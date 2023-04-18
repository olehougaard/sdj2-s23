package client;

import java.io.*;
import java.net.Socket;

public class ClientImplementation implements Client {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public ClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.writer = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public String convert(String source) throws IOException {
        writer.println(source);
        writer.flush();
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        writer.println("quit");
        writer.flush();
        socket.close();
    }
}
