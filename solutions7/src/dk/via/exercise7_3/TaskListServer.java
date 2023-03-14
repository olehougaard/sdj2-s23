package dk.via.exercise7_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        while (true) {
            Socket socket = serverSocket.accept();
            TaskListCommunicator communicator = new TaskListCommunicator(socket);
            Thread thread = new Thread(communicator);
            thread.start();
        }
    }
}
