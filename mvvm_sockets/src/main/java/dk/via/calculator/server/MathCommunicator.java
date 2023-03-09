package dk.via.calculator.server;

import com.google.gson.Gson;
import dk.via.calculator.model.Expression;
import dk.via.calculator.model.Result;
import dk.via.calculator.socket.StreamFactory;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;
    private final Gson gson;

    public MathCommunicator(Socket socket) {
        this.socket = socket;
        this.gson = new Gson();
    }

    private void communicate() throws IOException {
        try {
            BufferedReader input = StreamFactory.createReader(socket);
            PrintWriter output = StreamFactory.createWriter(socket);
            while (true) {
                String json = input.readLine();
                Expression expression = gson.fromJson(json, Expression.class);
                String operator = expression.getOperator();
                double a = expression.getOperand1();
                double b = expression.getOperand2();
                if (operator.equals("exit")) {
                    System.out.println("Exiting");
                    break;
                }
                Result r = switch (operator) {
                    case "+" -> new Result(a + b);
                    case "-" -> new Result(a - b);
                    case "*" -> new Result(a * b);
                    case "/" -> new Result(a / b);
                    default -> new Result(Double.NaN);
                };
                String resultJson = gson.toJson(r);
                output.println(resultJson);
                output.flush();
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
