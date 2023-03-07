package dk.via.math;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;

    public MathCommunicator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            ObjectInputStream input = new ObjectInputStream(inputStream);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);

            loop: while(true) {
                String request = (String) input.readObject();
                switch (request) {
                    case "+": {
                        double a = input.readDouble();
                        double b = input.readDouble();
                        output.writeDouble(a + b);
                        output.flush();
                        break;
                    }
                    case "-": {
                        double a = input.readDouble();
                        double b = input.readDouble();
                        output.writeDouble(a - b);
                        output.flush();
                        break;
                    }
                    case "exit":
                        break loop;
                }
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
