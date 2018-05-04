package code;


import code.clients.ClientFromFile;
import code.clients.IClientsList;
import code.orders.OrdersFromFile;
import code.stocks.Exchange;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Run {

    public static void main(String[] args) throws IOException {
    	Properties props = new Properties();
        String property_dir = System.getProperty("user.dir");
        try {
            props.load(new FileInputStream(property_dir + File.separator + "config.properties"));            
            IClientsList clientsList = new ClientFromFile(property_dir + File.separator + props.getProperty("clients"));
            OrdersFromFile ordersFromFile = new OrdersFromFile(property_dir + File.separator + props.getProperty("orders"));
            Exchange exchange = new Exchange(clientsList);
            ordersFromFile.apply(exchange);
            clientsList.writeToFile(property_dir + File.separator + props.getProperty("balance"));
            //System.out.println("Finish program");

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}