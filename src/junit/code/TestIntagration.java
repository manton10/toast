package junit.code;

import junit.framework.TestCase;
import code.clients.ClientFromFile;
import code.clients.IClientsList;
import code.stocks.Exchange;
import code.orders.OrdersFromFile;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestIntagration extends TestCase {

    @Test
    public void testExchange() throws IOException {

    	IClientsList customersList = new ClientFromFile("src/junit/files/clients.txt");
        OrdersFromFile ordersFromFile = new OrdersFromFile("src/junit/files/orders.txt");
        Exchange exchange = new Exchange(customersList);
        ordersFromFile.apply(exchange);
        customersList.writeToFile("src/junit/files/balance.txt");

        try(FileInputStream fis = new FileInputStream(new File("src/junit/files/balance.txt"))) {
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            assertEquals("884df53853e3b2af6b83b60203e5f18c", md5);
        }

    }
}
