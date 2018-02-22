package storeSystem;

public class CC extends Pagamento {

    private final String numeroCartao;
    private final int parcelas;

    public CC(String numeroCartao, double valor, int parcelas) {
        super(TipoPagamento.CC, valor);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
    }

    @Override
    boolean validarPagamento() {
        return validarCartao(numeroCartao, getValor(), parcelas);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    private boolean validarCartao(String numeroCartao, double valor, int parcelas) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
        return true;
    }
}
