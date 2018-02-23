package frontend;

import storeSystem.Boleto;
import storeSystem.GerenciadorCompra;

public class BoletoRouteene implements CheckoutRouteene {

    @Override
    public void run(GerenciadorCompra gerenciador) {
        Boleto boleto = new Boleto();
        System.out.println("Código do boleto: " + boleto.getCodigo());
        gerenciador.validarCompra(boleto);
    }
}
