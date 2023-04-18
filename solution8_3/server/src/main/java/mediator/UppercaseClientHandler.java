package mediator;

import java.io.*;
import java.net.*;

import model.Model;

public class UppercaseClientHandler implements Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Model model;
  private boolean running;

  public UppercaseClientHandler(Socket socket, Model model)
      throws IOException
  {
    this.model = model;
    this.socket = socket;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void run()
  {
    running = true;
    while (running)
    {
      try
      {
        String request = in.readLine();
        model.addLog("Client> " + request);
        String reply = model.convert(request);
        model.addLog("Server> " + reply);
        out.println(reply);
        if (request.contentEquals("quit"))
        {
          close();
        }
      }
      catch (Exception e)
      {
        model.addLog("Client error");
        close();
      }
    }
    close();
  }
  
  public void close()
  {
    running = false;
    try
    {
      in.close();
      out.close();
      socket.close();
    }
    catch (IOException e)
    {
      //
    }
  }
}
