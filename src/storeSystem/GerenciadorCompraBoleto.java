package storeSystem;

public class GerenciadorCompraBoleto extends GerenciadorCompra {

    private String codigo;

    public GerenciadorCompraBoleto(Carrinho carrinho, Cliente cliente) {
        super(carrinho, cliente);
    }

    @Override
    void validarPagamento(TipoPagamento tipo) {
        Boleto boleto = new Boleto(getCarrinho().getValor());
        codigo = boleto.getCodigo();
        boleto.validarPagamento();
    }

    public String getCodigo() {
        return codigo;
    }
}
