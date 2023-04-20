package dk.via.exercise14_1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dictionary extends Remote {
    String randomWord(int length) throws RemoteException;
    boolean lookup(String word) throws RemoteException;
}
