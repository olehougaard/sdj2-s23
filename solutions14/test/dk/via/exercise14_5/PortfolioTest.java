package dk.via.exercise14_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {
    private StockPrices prices;
    private Portfolio portfolio;

    @BeforeEach
    void setUp() {
        prices = Mockito.mock(StockPrices.class);
        portfolio = new Portfolio(prices);
    }

    @Test
    void new_portfolio_has_zero_stock() {
        assertEquals(0, portfolio.getStocks("GOOG"));
    }

    @Test
    void new_portfolio_has_zero_worth() throws RemoteException {
        assertEquals(BigDecimal.ZERO, portfolio.netWorth());
    }

    @Test
    void adding_to_portfolio_gives_it_those_stocks() {
        portfolio.add("GOOG", 100);
        assertEquals(100, portfolio.getStocks("GOOG"));
    }

    @Test
    void adding_two_stocks_to_portfolio_gives_it_both_stocks() {
        portfolio.add("GOOG", 100);
        portfolio.add("AAPL", 200);
        assertEquals(100, portfolio.getStocks("GOOG"));
        assertEquals(200, portfolio.getStocks("AAPL"));
    }

    @Test
    void adding_two_stocks_to_portfolio_gives_it_value_of_both() throws RemoteException {
        portfolio.add("GOOG", 100);
        portfolio.add("AAPL", 200);
        Mockito.when(prices.getPrice("GOOG")).thenReturn(BigDecimal.valueOf(10584, 2)); //105.84
        Mockito.when(prices.getPrice("AAPL")).thenReturn(BigDecimal.valueOf(15928, 2)); //159.28
        assertEquals(BigDecimal.valueOf(4244000, 2), portfolio.netWorth());
    }

    @Test
    void adding_the_same_stock_twice_adds_the_amounts() {
        portfolio.add("GOOG", 100);
        portfolio.add("GOOG", 200);
        assertEquals(300, portfolio.getStocks("GOOG"));
    }

    @Test
    void removing_stock_decreases_the_amount() {
        portfolio.add("GOOG", 200);
        portfolio.remove("GOOG", 100);
        assertEquals(100, portfolio.getStocks("GOOG"));
    }

    @Test
    void adding_negative_stocks_is_an_error() {
        assertThrows(IllegalArgumentException.class, () -> {
            portfolio.add("GOOG", -1);
        });
    }

    @Test
    void removing_negative_stocks_is_an_error() {
        assertThrows(IllegalArgumentException.class, () -> {
            portfolio.remove("GOOG", -1);
        });
    }

    @Test
    void removing_more_stocks_than_you_have_is_an_error() {
        assertThrows(IllegalArgumentException.class, () -> {
            portfolio.add("GOOG", 100);
            portfolio.remove("GOOG", 101);
        });
    }

    @Test
    void netWorth_rethrows_exceptions_from_the_service() {
        assertThrows(RemoteException.class, () -> {
            Mockito.doThrow(new RemoteException()).when(prices).getPrice(Mockito.anyString());
            portfolio.add("GOOG", 100);
            portfolio.netWorth();
        });
    }
}
