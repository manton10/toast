package code.clients;

import code.orders.Order;
import code.stocks.StockName;

public interface IClient {
    void sell(Order order);
    void buy(Order order);

    String getName();
    int getCashUSD();
    int getStockQuality (StockName name);
}
