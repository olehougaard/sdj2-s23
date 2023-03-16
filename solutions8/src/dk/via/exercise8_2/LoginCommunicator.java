package dk.via.exercise8_2;

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
            ObjectInputStream input = new ObjectInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(outputStream);

            String request = (String) input.readObject();
            if (request.equals("connect")) {
                output.writeObject("Login required");
                output.flush();
                Login login = (Login) input.readObject();
                if (login.getUsername().isBlank() || login.getPassword().isBlank()) { // In real situations: Replace with proper check
                    output.writeObject("Disconnected");
                } else {
                    output.writeObject("Approved"); // In real situation: Return a unique token as proof of login
                }
                output.flush();
            } else {
                output.writeObject("Disconnected");
                output.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
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
