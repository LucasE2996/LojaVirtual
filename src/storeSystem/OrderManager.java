package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public class OrderManager {
    private final ShoppingCart shoppingCart;
    private final FakeDB DB;

    public OrderManager(FakeDB DB, ShoppingCart shoppingCart) {
        this.DB = DB;
        this.shoppingCart = shoppingCart;
    }

    public void validarCompra(PaymentOption paymentOption, Client client) {
        validarPagamento(paymentOption);
        addCompraToCliente(paymentOption, client);
    }

    public double getValordaCompra() {
        return shoppingCart.getValor();
    }

    private void addCompraToCliente(PaymentOption paymentOption, Client client) {
        Order order = new Order( shoppingCart.getItems(), shoppingCart.getValor(), paymentOption);
        client.addCompra(order);
    }

    private void validarPagamento(PaymentOption paymentOption) {
        paymentOption.validarPagamento();
    }
}
