package dk.via.protocol;

import java.io.*;
import java.net.Socket;

public class EchoClientImplementation implements EchoClient {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public EchoClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.writer = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public String echo(String message) throws IOException {
        writer.println("echo");
        writer.println(message);
        writer.flush();
        return reader.readLine();
    }

    @Override
    public String uppercase(String message) throws IOException {
        writer.println("uppercase");
        writer.println(message);
        writer.flush();
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        writer.println("exit");
        writer.flush();
        socket.close();
    }
}
