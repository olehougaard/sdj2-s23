package dk.via.echo;

import java.io.*;
import java.net.Socket;

public class EchoClientImplementation implements EchoClient {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public EchoClientImplementation(String host, int port) throws IOException {
        socket = new Socket(host, port);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        reader = new BufferedReader(inputStreamReader);
        writer = new PrintWriter(outputStream);
    }

    @Override
    public String echo(String message) throws IOException {
        writer.println(message); // Puts the message into the send buffer
        writer.flush(); // Actually sends the message
        String response = reader.readLine();
        return response;
    }

    @Override
    public void close() throws IOException {
        writer.println("exit");
        writer.flush();
        socket.close();
    }
}
