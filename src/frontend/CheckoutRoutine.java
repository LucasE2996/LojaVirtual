package frontend;

import storeSystem.Client;
import storeSystem.OrderManager;
import storeSystem.ShoppingCart;

interface CheckoutRoutine {
    void run(OrderManager gerenciador, Client client, ShoppingCart shoppingCart);
}
