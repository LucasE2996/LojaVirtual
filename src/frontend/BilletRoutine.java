package frontend;

import storeSystem.Billet;
import storeSystem.Client;
import storeSystem.OrderManager;
import storeSystem.ShoppingCart;

public class BilletRoutine implements CheckoutRoutine {

    @Override
    public void run(OrderManager manager, Client client, ShoppingCart shoppingCart) {
        Billet billet = new Billet(gerarCodigo());
        System.out.printf("Valor toal da compra: %.2f" + "\n", shoppingCart.getValor());
        System.out.println("Código do boleto: " + billet.getCodigo());
        manager.addCompraToClient(billet, client);
    }

    private int gerarCodigo() {
        return (int)(Math.random() * 999999999);
    }
}
