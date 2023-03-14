package dk.via.exercise7_3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskListClient {
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

    public TaskListClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
    }

    public void add(Task task) throws IOException {
        output.writeObject("ADD");
        output.writeObject(task.getText());
        output.writeLong(task.getEstimatedTime());
        output.flush();
        Object reply = null;
        try {
            reply = input.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Protocol error", e);
        }
        if (!reply.equals("ADD")) throw new IOException("Protocol error");
    }

    public Task get() throws IOException {
        output.writeObject("GET");
        output.flush();
        try {
            String reply = (String) input.readObject();
            if (reply.equals("ERROR")) {
                throw new IllegalStateException("No tasks");
            } else {
                long estimatedTime = input.readLong();
                return new Task(reply, estimatedTime);
            }
        } catch (ClassNotFoundException e) {
            throw new IOException("Protocol error");
        }
    }

    public int getSize() throws IOException {
        output.writeObject("SIZE");
        output.flush();
        return input.readInt();
    }

    public void close() throws IOException {
        output.writeObject("EXIT");
        try {
            Object reply = input.readObject();
            if (!reply.equals("EXIT")) throw new IOException("Protocol error");
        } catch (ClassNotFoundException e) {
            throw new IOException("Protocol error");
        }
        socket.close();
    }
}
