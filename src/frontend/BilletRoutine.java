package frontend;

import storeSystem.Billet;
import storeSystem.Client;
import storeSystem.OrderManager;

public class BilletRoutine implements CheckoutRoutine {


    @Override
    public void run(OrderManager manager, Client client) {
        Billet billet = new Billet(gerarCodigo());
        System.out.printf("Valor toal da compra: %.2f" + "\n", manager.getValordaCompra());
        System.out.println("Código do billet: " + billet.getCodigo());
        manager.validarCompra(billet, client);
    }

    // if it was a real billet, it would call other object to do this.
    private int gerarCodigo() {
        return (int)(Math.random() * 999999999);
    }
}
