package dk.via.broadcast.client;

import com.google.gson.Gson;
import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;

public class   MathClientImplementation implements MathClient {
    private static final String EXIT_JSON = """
    {"operator": "exit"}
    """;

    private final Socket socket;
    private final PrintWriter output;
    private final Gson gson;
    private final PropertyChangeSupport support;
    private String latestResponse;

    public MathClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.output = new PrintWriter(socket.getOutputStream());
        this.gson = new Gson();
        this.support = new PropertyChangeSupport(this);

        MessageListener listener = new MessageListener(socket, this);
        Thread thread = new Thread(listener);
        thread.start();
    }

    @Override
    public synchronized double plus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Result result = gson.fromJson(latestResponse, Result.class);
        return result.getValue();
    }

    @Override
    public synchronized double minus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Result result = gson.fromJson(latestResponse, Result.class);
        return result.getValue();
    }

    @Override
    public void close() throws IOException {
        output.println(EXIT_JSON);
        output.flush();
        socket.shutdownInput();
    }

    public void closeSocket() throws IOException {
        socket.close();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void receiveBroadcast(String message) {
        Result result = gson.fromJson(message, Result.class);
        support.firePropertyChange("result", null, result);
    }

    public synchronized void receiveResponse(String response) {
        latestResponse = response;
        notify();
    }
}
