import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private final int orderId;
    private List<String> items;
    private double totalPrice;

    public Order() {
        this.orderId = nextId++;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addItem(String item, double price) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Поле \"Товар\" не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена товара не может быть нулевой или отрицательной");
        }
        items.add(item);
        totalPrice += price;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderInfo() {
        return String.format("Order ID: %s\nItems: %s\nTotal Price: %s", orderId, items, totalPrice);
    }
}
