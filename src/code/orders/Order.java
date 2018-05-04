package code.orders;

import code.stocks.StockName;


public class Order {
    private StockName stockName;
    private int price;
    private int quantity;

    public Order(StockName stockName, int price, int quantity) {
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
    }


    public StockName getStockName() {
        return stockName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (price != order.price) return false;
        if (quantity != order.quantity) return false;
        return stockName == order.stockName;

    }

    @Override
    public int hashCode() {
        int result = stockName.hashCode();
        result = 31 * result + price;
        result = 31 * result + quantity;
        return result;
    }
}
