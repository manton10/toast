package junit.code;

import junit.framework.TestCase;
import code.clients.Client;
import code.clients.IClient;
import code.clients.IClientsList;
import code.operation.Buy;
import code.operation.IOperation;
import code.operation.Sell;
import code.stocks.StockName;
import org.junit.Test;

public class TestOperations extends TestCase {

    @Test
    public void testBuyOperation() {
        final IClient client = new Client("C1", 1000, 130, 240, 760,320);
        IOperation buy = new Buy("C1", StockName.A, 10, 5);
        buy.apply(new IClientsList() {
            @Override
            public IClient getCustomerByName(String name) {
                return client;
            }

            @Override
            public void writeToFile(String FileName) {

            }
        });
        assertEquals(1000 - 10 * 5, client.getCashUSD());
        assertEquals(130 + 5, client.getStockQuality(StockName.A));
    }

    @Test
    public void testSellOperation() {
        final IClient client = new Client("C1", 1000, 130, 240, 760,320);
        IOperation sell = new Sell("C1", StockName.A, 10, 5);
        sell.apply(new IClientsList() {
            @Override
            public IClient getCustomerByName(String name) {
                return client;
            }

            @Override
            public void writeToFile(String FileName) {

            }
        });
        assertEquals(1000 + 10 * 5, client.getCashUSD());
        assertEquals(130 - 5, client.getStockQuality(StockName.A));
    }
}
