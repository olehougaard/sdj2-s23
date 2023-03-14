package dk.via.exercise7_1;

import java.io.*;
import java.net.Socket;

public class LoginCommunicator implements Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public LoginCommunicator(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while(true) {
                String method = reader.readLine();
                if (!method.equals("connect")) {
                    break;
                }
                writer.println("Username?");
                writer.flush();
                String userName = reader.readLine();
                writer.println("Password?");
                writer.flush();
                String password = reader.readLine();
                if (userName.isEmpty() || password.isEmpty()) { // Need better check in real scenario
                    break;
                }
                writer.println("Approved");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.println("Disconnected");
            writer.flush();
            try {
                socket.close();
                System.out.println("Socket closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
