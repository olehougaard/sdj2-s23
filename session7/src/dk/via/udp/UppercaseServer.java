package dk.via.udp;

import java.io.*;
import java.net.*;

public class UppercaseServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        while(true) {
            try {
                byte[] incoming = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incoming, incoming.length);
                System.out.println("Server is ready for input port 8888");
                socket.receive(incomingPacket); // Waiting for requests
                InetAddress clientAddress = incomingPacket.getAddress();
                int clientPort = incomingPacket.getPort();
                String request = new String(incoming).trim();

                String reply = request.toUpperCase();
                DatagramPacket response = new DatagramPacket(reply.getBytes(), reply.length(), clientAddress, clientPort);
                socket.send(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
