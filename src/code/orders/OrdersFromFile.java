package code.orders;

import code.operation.OperatoinFactory;
import code.stocks.IExchange;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrdersFromFile {

    private OperatoinFactory operatoinFactory = new OperatoinFactory();
    private final String fileNameOrders;

    public OrdersFromFile(String fileName) {
        fileNameOrders = fileName;
    }

    public void apply(IExchange exchange) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileNameOrders))) {
            stream.forEach(data -> operatoinFactory.get(data).addToQueue(exchange));
        }
    }
}
