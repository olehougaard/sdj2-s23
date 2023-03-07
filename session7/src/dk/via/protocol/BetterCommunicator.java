package dk.via.protocol;

import java.io.*;
import java.net.Socket;

public class BetterCommunicator implements Runnable {
    private final Socket socket;

    public BetterCommunicator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            loop: while(true) {
                String request = reader.readLine();
                switch(request) {
                    case "exit":
                        break loop;
                    case "echo":
                        String message = reader.readLine();
                        writer.println(message);
                        writer.flush();
                        break;
                    case "uppercase":
                        String message1 = reader.readLine();
                        writer.println(message1.toUpperCase());
                        writer.flush();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
