package code.operation;

import code.stocks.IExchange;
import code.stocks.StockName;
import code.clients.IClientsList;

public class Buy extends AOperation implements IOperation {

    public Buy(String clientName, StockName stockName, int price, int quantity) {
        super(clientName, stockName, price, quantity);
    }

    @Override
    public void apply(IClientsList clients) {
        clients.getCustomerByName(this.clientName).buy(order);
    }

    @Override
    public void addToQueue(IExchange exchange) {
        exchange.buyOperation(this);
    }


}
