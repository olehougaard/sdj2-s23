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
    private final BufferedReader input;
    private final MessageListener listener;

    public MathClientImplementation(String host, int port, String groupAddress, int groupPort) throws IOException {
        this.socket = new Socket(host, port);
        this.output = new PrintWriter(socket.getOutputStream());
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.gson = new Gson();
        this.support = new PropertyChangeSupport(this);

        listener = new MessageListener(this, groupAddress, groupPort);
        Thread thread = new Thread(listener);
        thread.start();
    }

    @Override
    public double plus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        String resultJson = input.readLine();
        Result result = gson.fromJson(resultJson, Result.class);
        return result.getValue();
    }

    @Override
    public double minus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        String resultJson = input.readLine();
        Result result = gson.fromJson(resultJson, Result.class);
        return result.getValue();
    }

    @Override
    public void close() throws IOException {
        listener.close();
        output.println(EXIT_JSON);
        output.flush();
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
}
