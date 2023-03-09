package dk.via.objectstream;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;

    public MathCommunicator(Socket socket) {
        this.socket = socket;
    }

    private void communicate() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            ObjectInputStream input = new ObjectInputStream(inputStream);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);

            loop: while(true) {
                Expression request = (Expression) input.readObject();
                String operator = request.getOperator();
                double a = request.getOperand1();
                double b = request.getOperand2();
                switch (operator) {
                    case "+": {
                        Result result = new Result(a + b);
                        output.writeObject(result);
                        output.flush();
                        break;
                    }
                    case "-": {
                        Result result = new Result(a - b);
                        output.writeObject(result);
                        output.flush();
                        break;
                    }
                    case "exit":
                        break loop;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
