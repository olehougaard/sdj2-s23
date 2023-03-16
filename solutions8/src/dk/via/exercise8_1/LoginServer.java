package dk.via.login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true) {
            System.out.println("Server is ready for input port 8888");
            Socket socket = serverSocket.accept();
            LoginCommunicator communicator = new LoginCommunicator(socket);
            Thread communicatorThread = new Thread(communicator);
            communicatorThread.start();
        }
    }
}
