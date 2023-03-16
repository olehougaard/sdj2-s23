package dk.via.broadcast.server;

import com.google.gson.Gson;
import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Login;
import dk.via.broadcast.model.Result;

import java.io.*;
import java.net.Socket;

public class LoginCommunicator implements Runnable {
    private final Socket socket;
    private final UDPBroadcaster broadcaster;
    private final Gson gson;

    public LoginCommunicator(Socket socket, UDPBroadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();
    }

    private void communicate() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            PrintWriter writer = new PrintWriter(outputStream);

            while (true) {
                String request = reader.readLine();
                if (request.equals("connect")) {
                    writer.println("Login required");
                    writer.flush();
                    String loginJson = reader.readLine();
                    Login login = gson.fromJson(loginJson, Login.class);
                    if (login.getUsername().isBlank() || login.getPassword().isBlank()) { // In real situations: Replace with proper check
                        writer.println("Not approved");
                    } else {
                        writer.println("Approved"); // In real situation: Return a unique token as proof of login
                        broadcaster.broadcast(loginJson);
                    }
                    writer.flush();
                } else {
                    writer.println("Disconnected");
                    writer.flush();
                    break;
                }
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
