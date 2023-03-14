package dk.via.exercise7_3;

import java.io.*;
import java.net.Socket;

public class TaskListCommunicator implements Runnable {
    private final TaskList taskList;
    private final Socket socket;

    public TaskListCommunicator(Socket socket) throws IOException {
        this.socket = socket;
        this.taskList = new TaskList();
    }

    public void run() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            loop: while(true) {
                String method = (String) input.readObject();
                switch(method) {
                    case "ADD":
                        String text = (String) input.readObject();
                        long estimatedTime = input.readLong();
                        taskList.add(new Task(text, estimatedTime));
                        output.writeObject("ADD");
                        output.flush();
                        break;
                    case "GET":
                        if (taskList.size() == 0) {
                            output.writeObject("ERROR");
                        } else {
                            Task task = taskList.getAndRemoveNextTask();
                            output.writeObject(task.getText());
                            output.writeLong(task.getEstimatedTime());
                        }
                        output.flush();
                        break;
                    case "SIZE":
                        output.writeInt(taskList.size());
                        output.flush();
                        break;
                    default:
                        output.writeObject("EXIT");
                        output.flush();
                        break loop;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
