package dk.via.exercise11_3.step2.server;

import dk.via.exercise11_3.step2.RemoteMessageList;
import dk.via.exercise11_3.step2.RemoteSender;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RmiCallbackServer implements RemoteMessageList {
    private final ArrayList<String> messageList;


    public RmiCallbackServer() {
        messageList = new ArrayList<>();
    }

    @Override
    public String getLastMessage() {
        if (messageList.isEmpty())
            return null;
        else
            return messageList.get(messageList.size() - 1);
    }

    @Override
    public void addMessage(String message, RemoteSender callback) throws RemoteException {
        messageList.add(message);
        System.out.println(message);
        callback.replyMessage("Thanks");
    }
}
