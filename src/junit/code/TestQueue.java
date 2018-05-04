package junit.code;

import junit.framework.TestCase;
import code.operation.Buy;
import code.operation.IOperation;
import code.operation.Sell;
import code.orders.Order;
import code.orders.OrdersQueue;
import code.stocks.StockName;
import org.junit.Test;


public class TestQueue extends TestCase {

    @Test
    public void testEmptyQueue() {
        OrdersQueue queue = new OrdersQueue();
        assertFalse(queue.checkOrder(new Order(StockName.A, 10, 5)));
    }

    @Test
    public void testElementQueue() {        
        OrdersQueue queue = new OrdersQueue();
        IOperation operation = new Sell("C1", StockName.A, 10, 5);
        queue.addOrder(operation);
        assertTrue(queue.checkOrder(new Order(StockName.A, 10, 5)));
    }

    @Test
    public void testDeleteDubleElementsQueue() {
        
        OrdersQueue queue = new OrdersQueue();
        IOperation operation = new Buy("C1", StockName.A, 10, 5);
        Order order = new Order(StockName.A, 10, 5);
        queue.addOrder(operation);
        queue.addOrder(operation);
        
        queue.pullOrder(order);
        assertTrue(queue.checkOrder(order));
        
        queue.pullOrder(order);
        assertFalse(queue.checkOrder(order));
    }

    @Test
    public void testDeleteElementsQueue() {
        
        OrdersQueue queue = new OrdersQueue();
        IOperation operation1 = new Buy("C1", StockName.A, 10, 5);
        IOperation operation2 = new Sell("C2", StockName.B, 50, 2);
        Order order1 = new Order(StockName.A, 10, 5);
        Order order2 = new Order(StockName.B, 50, 2);
        queue.addOrder(operation1);
        queue.addOrder(operation2);
        
        queue.pullOrder(order2);
        assertFalse(queue.checkOrder(order2));
        assertTrue(queue.checkOrder(order1));
        
        queue.pullOrder(order1);
        assertFalse(queue.checkOrder(order1));
    }
}
