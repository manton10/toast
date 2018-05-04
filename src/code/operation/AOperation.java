package code.operation;

import code.orders.Order;
import code.stocks.StockName;

public abstract class AOperation {

    protected final String clientName;
    protected final Order order;

    AOperation(String clientName, StockName stockName, int price, int quantity) {
        this.clientName = clientName;
        order = new Order(stockName, price, quantity);
    }

    public Order getOrder() {
        return order;
    }




}
