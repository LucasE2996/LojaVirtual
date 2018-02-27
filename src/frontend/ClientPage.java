package frontend;

import storeSystem.Client;
import storeSystem.Order;

public class ClientPage {

    void run(Client client) {
        System.out.println("\nCompras realizadas pelo cliente de ID: " + client.getId());
        for (Order order: client.getOrders()
             ) {
            System.out.println("-----------------------");
            System.out.println("valor da compra: " + order.getOrderValue());
            System.out.println("Tipo de pagamento: " + order.getPaymentOption().getTipo().toString().toLowerCase());
            System.out.println("Itens da compra:");
            order.getItems().forEach(item -> System.out.println(item.getProductName() +"\tx"+item.getQuantity()));
            System.out.println("-----------------------");
        }
    }
}
