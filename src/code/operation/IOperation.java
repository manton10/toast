package code.operation;

import code.orders.Order;
import code.stocks.IExchange;
import code.clients.IClientsList;

public interface IOperation {
    void apply (IClientsList customers);
    void addToQueue(IExchange exchange);
    Order getOrder();
}
