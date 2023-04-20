package dk.via.exercise14_5;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockPrices extends Remote {
    BigDecimal getPrice(String tickerSymbol) throws RemoteException;
}
