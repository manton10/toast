package code.operation;

import code.stocks.IExchange;
import code.stocks.StockName;
import code.clients.IClientsList;

public class Sell extends AOperation implements IOperation {

    public Sell(String clientName, StockName stockName, int price, int quantity) {
        super(clientName, stockName, price, quantity);
    }

    @Override
    public void apply(IClientsList customers) {
        customers.getCustomerByName(this.clientName).sell(order);
    }

    @Override
    public void addToQueue(IExchange exchange) {
        exchange.sellOperation(this);
    }

}
