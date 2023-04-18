package dk.via.broadcast.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Broadcaster {
    private final ArrayList<Socket> sockets;

    public Broadcaster() {
        sockets = new ArrayList<>();
    }

    public synchronized void addRecipient(Socket socket) {
        sockets.add(socket);
    }

    public synchronized void removeRecipient(Socket socket) {
        sockets.remove(socket);
    }

    public synchronized void broadcast(String message) throws IOException {
        for(Socket socket: sockets) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("broadcast");
            writer.println(message);
            writer.flush();
        }
    }
}
