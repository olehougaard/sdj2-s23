package dk.via.exercise7_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            LoginCommunicator communicator = new LoginCommunicator(socket);
            Thread thread = new Thread(communicator);
            thread.start();
        }
    }
}
