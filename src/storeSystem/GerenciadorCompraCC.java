package storeSystem;

public class GerenciadorCompraCC extends GerenciadorCompra {

    private String numCartao;
    private int parcelas;

    public GerenciadorCompraCC(Carrinho carrinho, Cliente cliente, String numCartao, int parcelas) {
        super(carrinho, cliente);
        this.numCartao = numCartao;
        this.parcelas = parcelas;
    }

    public String getNumCartao() {
        return numCartao;
    }

    @Override
    void validarPagamento(TipoPagamento tipo) {
        CC cc = new CC(getCarrinho().getValor());
        cc.setNumeroCartao(numCartao);
        cc.setParcelas(parcelas);
        cc.validarPagamento();
    }
}
