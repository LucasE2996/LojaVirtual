package frontend;

import storeSystem.Boleto;
import storeSystem.GerenciadorCompra;

public class BoletoRouteene implements CheckoutRouteene {

    @Override
    public void run(GerenciadorCompra gerenciador) {
        System.out.printf("Valor toal da compra: %.2f" + "\n", gerenciador.getValordaCompra());
        Boleto boleto = new Boleto();
        System.out.println("Código do boleto: " + boleto.getCodigo());
        gerenciador.validarCompra(boleto);
    }
}
