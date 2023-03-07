package dk.via.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UppercaseClientImplementation implements UppercaseClient {
    private final DatagramSocket socket;
    private final InetAddress serverAddress;
    private final int port;
    private final byte[] responseBuffer;

    public UppercaseClientImplementation(String host, int port) throws IOException {
        this.port = port;
        this.socket = new DatagramSocket();
        this.serverAddress = InetAddress.getByName(host);
        this.responseBuffer = new byte[1024];
    }

    @Override
    public String uppercase(String message) throws IOException {
        byte[] messageBytes = message.getBytes();
        DatagramPacket request = new DatagramPacket(messageBytes, messageBytes.length, serverAddress, port);
        socket.send(request);

        DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
        socket.receive(response);

        return new String(responseBuffer).trim();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
