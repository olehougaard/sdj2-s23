package dk.via.math;

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
        output.writeObject("+");
        output.writeDouble(operand1);
        output.writeDouble(operand2);
        output.flush();
        return input.readDouble();
    }

    @Override
    public double minus(double operand1, double operand2) throws IOException {
        output.writeObject("-");
        output.writeDouble(operand1);
        output.writeDouble(operand2);
        output.flush();
        return input.readDouble();
    }

    @Override
    public void close() throws IOException {
        output.writeObject("exit");
        output.flush();
        socket.close();
    }
}
