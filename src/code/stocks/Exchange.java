package code.stocks;

import code.clients.IClientsList;
import code.operation.*;
import code.orders.OrdersQueue;

public class Exchange implements IExchange {


    private final IClientsList clients;
    private OrdersQueue sellQueue = new OrdersQueue();
    private OrdersQueue buyQueue = new OrdersQueue();

    public Exchange(IClientsList customersList) {
        this.clients = customersList;
    }

    @Override
    public void buyOperation(Buy operation) {
        if(sellQueue.checkOrder(operation.getOrder())) {
            operation.apply(clients);
            sellQueue.pullOrder(operation.getOrder()).apply(clients);
        }
        else {
            buyQueue.addOrder(operation);
        }
    }

    @Override
    public void sellOperation(Sell operation) {
        if(buyQueue.checkOrder(operation.getOrder())) {
            operation.apply(clients);
            buyQueue.pullOrder(operation.getOrder()).apply(clients);
        }
        else {
            sellQueue.addOrder(operation);
        }
    }
}
