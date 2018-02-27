package storeSystem;

import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Item> items;
    private final PaymentOption paymentOption;
    private float valor;

    Order(List<Item> items, float valor, PaymentOption paymentOption) {
        this.items = items;
        this.paymentOption = paymentOption;
        this.valor = valor;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
    public PaymentOption getPaymentOption() {
        return paymentOption;
    }
    public float getOrderValue() {
        return valor;
    }
}
