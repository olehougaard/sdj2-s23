package dk.via.objectstream;

import java.io.*;
import java.net.Socket;

public class MathClientImplementation implements MathClient {
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

    public MathClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.output = new ObjectOutputStream(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.input = new ObjectInputStream(inputStream);
    }

    @Override
    public double plus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        output.writeObject(expression);
        output.flush();
        Result result = null;
        try {
            result = (Result) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IOException("Protocol error. Class not found: " + e.getMessage());
        }
        return result.getValue();
    }

    @Override
    public double minus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        output.writeObject(expression);
        output.flush();
        Result result = null;
        try {
            result = (Result) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IOException("Protocol error. Class not found: " + e.getMessage());
        }
        return result.getValue();
    }

    @Override
    public void close() throws IOException {
        Expression expression = new Expression("exit", 0, 0);
        output.writeObject(expression);
        output.flush();
        socket.close();
    }
}
