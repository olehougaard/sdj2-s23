package dk.via.json;

import com.google.gson.Gson;

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
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter output = new PrintWriter(outputStream);

            loop: while(true) {
                String json = input.readLine();
                Expression expression = gson.fromJson(json, Expression.class);
                String operator = expression.getOperator();
                double a = expression.getOperand1();
                double b = expression.getOperand2();
                switch (operator) {
                    case "+": {
                        Result r = new Result(a + b);
                        String resultJson = gson.toJson(r);
                        output.println(resultJson);
                        output.flush();
                        break;
                    }
                    case "-": {
                        Result r = new Result(a - b);
                        String resultJson = gson.toJson(r);
                        output.println(resultJson);
                        output.flush();
                        break;
                    }
                    case "exit":
                        System.out.println("Exiting");
                        break loop;
                }
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
