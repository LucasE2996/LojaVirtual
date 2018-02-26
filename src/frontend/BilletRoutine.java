package frontend;

import storeSystem.Billet;
import storeSystem.Client;
import storeSystem.OrderManager;

public class BilletRoutine implements CheckoutRoutine {

    @Override
    public void run(OrderManager gerenciador, Client client) {
        System.out.printf("Valor toal da compra: %.2f" + "\n", gerenciador.getValordaCompra());
        Billet billet = new Billet();
        System.out.println("Código do billet: " + billet.getCodigo());
        gerenciador.validarCompra(billet, client);
    }
}
