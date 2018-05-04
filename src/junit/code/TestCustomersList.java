package junit.code;

import code.clients.AClientList;
import code.clients.IClient;


public class TestCustomersList extends AClientList  {

    public TestCustomersList(IClient... clients) {
        super();
        for (int i = 0; i < clients.length; i++) {
            this.addClient(clients[i]);
        }
    }
}
