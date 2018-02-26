package storeSystem;

import database.FakeDB;



public class OrderManager {
    private final ShoppingCart shoppingCart;
    private final FakeDB DB;

    public OrderManager(FakeDB DB, ShoppingCart shoppingCart) {
        this.DB = DB;
        this.shoppingCart = shoppingCart;
    }

    public void validarCompra(PaymentOption paymentOption, Client client) {
        Order order = new Order( shoppingCart.getItems(), shoppingCart.getValor(), paymentOption);
        client.addCompra(order);
    }

    public double getValordaCompra() {
        return shoppingCart.getValor();
    }

}
