package frontend;

import storeSystem.Client;
import storeSystem.OrderManager;

interface CheckoutRoutine {
    void run(OrderManager gerenciador, Client client);
}
