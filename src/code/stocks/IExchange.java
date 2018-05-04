package code.stocks;

import code.operation.Buy;
import code.operation.Sell;

public interface IExchange {
    void buyOperation(Buy operation);
    void sellOperation(Sell operation);
}
