package dk.via.exercise14_5;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.HashMap;

public class Portfolio {
    private final HashMap<String, Integer> stocks;
    private final StockPrices stockPrices;

    public Portfolio(StockPrices stockPrices) {
        this.stockPrices = stockPrices;
        this.stocks = new HashMap<>();
    }

    public BigDecimal netWorth() throws RemoteException {
        BigDecimal total = BigDecimal.ZERO;
        for(String symbol: stocks.keySet()) {
            BigDecimal price = this.stockPrices.getPrice(symbol);
            BigDecimal amount = BigDecimal.valueOf(stocks.get(symbol));
            total = total.add(price.multiply(amount));
        }
        return total;
    }

    public void add(String tickerSymbol, int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        stocks.put(tickerSymbol, getStocks(tickerSymbol) + amount);
    }

    public int getStocks(String tickerSymbol) {
        return stocks.getOrDefault(tickerSymbol, 0);
    }

    public void remove(String tickerSymbol, int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > getStocks(tickerSymbol)) throw new IllegalArgumentException("Amount exceeds stock");
        stocks.put(tickerSymbol, getStocks(tickerSymbol) - amount);
    }
}
