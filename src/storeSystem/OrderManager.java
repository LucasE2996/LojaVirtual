package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public class OrderManager {
    private final ShoppingCart shoppingCart;
    private final FakeDB DB;
    private Client client;

    public OrderManager(FakeDB DB, ShoppingCart shoppingCart) {
        this.DB = DB;
        this.shoppingCart = shoppingCart;
    }

    public void validarCompra(PaymentOption paymentOption) {
        validarPagamento(paymentOption);
        addCompraToCliente(paymentOption);
    }

    public void validarCliente(int id) {
        this.client = DB.getClients().stream()
                .filter(client1 -> client1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public double getValordaCompra() {
        return shoppingCart.getValor();
    }

    private void addCompraToCliente(PaymentOption paymentOption) {
        Order order = new Order( shoppingCart.getProducts(), shoppingCart.getValor(), paymentOption);
        client.addCompra(order);
    }

    private void validarPagamento(PaymentOption paymentOption) {
        paymentOption.validarPagamento();
    }
}
