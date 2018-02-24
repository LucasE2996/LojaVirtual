package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private final int id;
    private List<Order> orders;

    public Client(int id) {
        this.id = id;
        orders = new LinkedList<>();
    }

    void addCompra(Order order) {
        orders.add(order);
    }

    public int getId() {
        return id;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
