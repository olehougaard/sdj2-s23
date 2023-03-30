package dk.via.exercise11_3.step2.client;

import dk.via.exercise11_3.step2.RemoteMessageList;
import dk.via.exercise11_3.step2.RemoteSender;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiCallbackClient extends UnicastRemoteObject implements RemoteSender {
    private final RemoteMessageList remoteMessageList;

    public RmiCallbackClient(RemoteMessageList remoteMessageList) throws RemoteException {
        this.remoteMessageList = remoteMessageList;
    }

    public void send(String message) {
        try {
            remoteMessageList.addMessage(message, this);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void replyMessage(String message) {
        System.out.println("Received: " + message);
    }
}
