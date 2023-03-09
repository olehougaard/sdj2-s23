package dk.via.json;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class MathClientImplementation implements MathClient {
    private static final String EXIT_JSON = """
    {"operator": "exit"}
    """;

    private final Socket socket;
    private final PrintWriter output;
    private final BufferedReader input;
    private final Gson gson;

    public MathClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.output = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.input = new BufferedReader(inputStreamReader);
        this.gson = new Gson();
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
        output.println(EXIT_JSON);
        output.flush();
        socket.close();
    }
}
