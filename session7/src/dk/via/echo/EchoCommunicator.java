package dk.via.echo;

import java.io.*;
import java.net.Socket;

public class EchoCommunicator implements Runnable {
    private final Socket socket;

    public EchoCommunicator(Socket socket) {
        this.socket = socket;
    }

    private void execute() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                String message = reader.readLine();
                if (message.equals("exit")) {
                    break;
                }
                writer.println(message);
                writer.flush();
            }
        } finally {
            socket.close();
        }
    }

    public void run() {
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
