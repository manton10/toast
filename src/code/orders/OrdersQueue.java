package code.orders;

import code.operation.IOperation;

import java.util.*;


public class OrdersQueue {
    private Map<Order, Queue<IOperation>> ordersMap = new LinkedHashMap<>();

    public void addOrder(IOperation operation) {
        Order order = operation.getOrder();
        if (checkOrder(order)) {
            Queue<IOperation> list =  ordersMap.get(order);
            list.add(operation);
        }
        else {
            Queue<IOperation> list = new LinkedList<IOperation>();
            list.add(operation);
             ordersMap.put(order, list);
        }
    }

    public boolean checkOrder(Order order) {
        return  ordersMap.containsKey(order);
    }

    public IOperation pullOrder(Order order) {
        Queue<IOperation> list =  ordersMap.get(order);
        IOperation result = list.remove();
        if (list.isEmpty()) {
            ordersMap.remove(order);
        }
        return result;
    }
}
