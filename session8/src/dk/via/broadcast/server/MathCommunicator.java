package dk.via.broadcast.server;

import com.google.gson.Gson;
import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;
    private final Broadcaster broadcaster;
    private final Gson gson;

    public MathCommunicator(Socket socket, Broadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();
    }

    private void communicate() throws IOException {
        broadcaster.addRecipient(socket);
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter output = new PrintWriter(outputStream);

            loop: while(true) {
                String jsonRequest = input.readLine();
                Expression expression = gson.fromJson(jsonRequest, Expression.class);
                System.out.println(expression.getOperator());
                switch (expression.getOperator()) {
                    case "+": {
                        double a = expression.getOperand1();
                        double b = expression.getOperand2();
                        Result r = new Result(a + b, expression);
                        String json = gson.toJson(r);
                        output.println(json);
                        output.flush();
                        broadcaster.broadcast(json);
                        break;
                    }
                    case "-": {
                        double a = expression.getOperand1();
                        double b = expression.getOperand2();
                        Result r = new Result(a - b, expression);
                        String json = gson.toJson(r);
                        output.println(json);
                        output.flush();
                        broadcaster.broadcast(json);
                        break;
                    }
                    case "exit":
                        System.out.println("Exiting");
                        break loop;
                }
            }
        } finally {
            broadcaster.removeRecipient(socket);
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
