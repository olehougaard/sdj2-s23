package dk.via.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true) {
            System.out.println("Waiting for connection on " + serverSocket.getLocalPort());
            Socket socket = serverSocket.accept(); // Wait for connection.
            EchoCommunicator communicator = new EchoCommunicator(socket);
            Thread thread = new Thread(communicator);
            thread.start();
        }
    }
}
