package junit.code;

import junit.framework.TestCase;
import code.clients.Client;
import code.orders.Order;
import code.stocks.StockName;
import org.junit.Test;


public class TestClients extends TestCase {

    @Test
    public void testClientFromString() {
        Client client = new Client("C1\t1000\t130\t240\t760\t320");
        assertEquals("C1", client.getName());
        assertEquals(1000, client.getCashUSD());
        assertEquals(130, client.getStockQuality(StockName.A));
        assertEquals(240, client.getStockQuality(StockName.B));
        assertEquals(760, client.getStockQuality(StockName.C));
        assertEquals(320, client.getStockQuality(StockName.D));
    }

    @Test
    public void testBuy() {
    	Client client = new Client("C1", 1000, 130, 240, 760,320);
        client.buy(new Order(StockName.A, 100, 5));
        assertEquals(1000 - 100 * 5, client.getCashUSD());
        assertEquals(130 + 5, client.getStockQuality(StockName.A));
    }

    @Test
    public void testSell() {
    	Client client = new Client("C1", 1000, 130, 240, 760,320);
        client.sell(new Order(StockName.B, 50, 10));
        assertEquals(1000 + 50 * 10, client.getCashUSD());
        assertEquals(240 - 10, client.getStockQuality(StockName.B));
    }
}
