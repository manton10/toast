package junit.code;

import junit.framework.TestCase;
import code.clients.Client;
import code.clients.IClientsList;
import code.stocks.Exchange;
import code.operation.Buy;
import code.operation.Sell;
import code.stocks.StockName;
import org.junit.Test;


public class TestOrders extends TestCase {

    @Test
    public void testSucsessOrder() {
        IClientsList customersList = new TestCustomersList(
                new Client("C1", 1000, 100, 100, 100, 100),
                new Client("C2", 1000, 100, 100, 100, 100)
        );
        Exchange exchange = new Exchange(customersList);
        exchange.buyOperation(new Buy("C1", StockName.A, 100, 5));
        exchange.sellOperation(new Sell("C2", StockName.A, 100, 5));
        assertEquals(1000 - 100 * 5, customersList.getCustomerByName("C1").getCashUSD());
        assertEquals(1000 + 100 * 5, customersList.getCustomerByName("C2").getCashUSD());
        assertEquals(100 + 5, customersList.getCustomerByName("C1").getStockQuality(StockName.A));
        assertEquals(100 - 5, customersList.getCustomerByName("C2").getStockQuality(StockName.A));
    }

    @Test
    public void testUnsucsessOrder() {
        IClientsList customersList = new TestCustomersList(
                new Client("C1", 1000, 100, 100, 100, 100),
                new Client("C2", 1000, 100, 100, 100, 100)
        );
        Exchange exchange = new Exchange(customersList);
        exchange.buyOperation(new Buy("C1", StockName.A, 100, 5));
        exchange.sellOperation(new Sell("C2", StockName.B, 100, 5));
        assertEquals(1000, customersList.getCustomerByName("C1").getCashUSD());
        assertEquals(1000, customersList.getCustomerByName("C2").getCashUSD());
        assertEquals(100, customersList.getCustomerByName("C1").getStockQuality(StockName.A));
        assertEquals(100, customersList.getCustomerByName("C2").getStockQuality(StockName.A));

    }
}
