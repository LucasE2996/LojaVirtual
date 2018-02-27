package storeSystem;

public class OrderManager {
    private final ShoppingCart shoppingCart;

    public OrderManager(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addCompraToClient(PaymentOption paymentOption, Client client) {
        Order order = new Order( shoppingCart.getItems(), shoppingCart.getValor(), paymentOption);
        client.addCompra(order);
    }
}
