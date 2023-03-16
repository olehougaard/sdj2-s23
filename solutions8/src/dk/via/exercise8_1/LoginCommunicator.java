package dk.via.login;

import java.io.*;
import java.net.Socket;

public class LoginCommunicator implements Runnable {
    private final Socket socket;

    public LoginCommunicator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            String request = reader.readLine();
            if (request.equals("connect")) {
                writer.println("Username?");
                writer.flush();
                String username = reader.readLine();
                writer.println("Password?");
                writer.flush();
                String password = reader.readLine();
                if (username.isBlank() || password.isBlank()) { // In real situations: Replace with proper check
                    writer.println("Disconnected");
                } else {
                    writer.println("Approved"); // In real situation: Return a unique token as proof of login
                }
                writer.flush();
            } else {
                writer.println("Disconnected");
                writer.flush();
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
