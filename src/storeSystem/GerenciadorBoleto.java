package storeSystem;

import database.FakeDB;

public class GerenciadorBoleto extends GerenciadorCompra {

    public GerenciadorBoleto(FakeDB DB, Carrinho carrinho) {
        super(DB, carrinho);
    }

    @Override
    Pagamento createPagamento(TipoPagamento tipo, double value) {
        return new Boleto(value);
    }
}
