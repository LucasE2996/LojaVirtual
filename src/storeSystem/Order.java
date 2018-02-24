package storeSystem;

import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Product> products;
    private final PaymentOption paymentOption;
    private float valor;

    Order(List<Product> products, float valor, PaymentOption paymentOption) {
        this.products = products;
        this.paymentOption = paymentOption;
        this.valor = valor;
    }

    public List<Product> produtos() {
        return Collections.unmodifiableList(products);
    }

    public PaymentOption getPagamentoTipo() {
        return paymentOption;
    }

    public float getValorCompra() {
        return valor;
    }
}
