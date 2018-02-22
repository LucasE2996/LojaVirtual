package storeSystem;

import database.FakeDB;

public class GerenciadorCC extends GerenciadorCompra {

    private String numCartao;
    private int parcelas;

    public GerenciadorCC(FakeDB DB, Carrinho carrinho) {
        super(DB, carrinho);
    }

    public GerenciadorCC(FakeDB db, Carrinho carrinho, String numCartao, int parcelas) {
        super(db, carrinho);
        this.numCartao = numCartao;
        this.parcelas = parcelas;
    }

    @Override
    Pagamento createPagamento(TipoPagamento tipo, double value) {
        return new CC(numCartao, value, parcelas);
    }
}
