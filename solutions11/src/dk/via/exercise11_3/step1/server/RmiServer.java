package dk.via.exercise11_3.step1.server;

import dk.via.exercise11_3.step1.RemoteMessageList;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RmiServer implements RemoteMessageList {
    private final ArrayList<String> messageList;


    public RmiServer() {
        messageList = new ArrayList<>();
    }

    @Override
    public void addMessage(String message) throws RemoteException {
        messageList.add(message);
        System.out.println(message);
    }
}
