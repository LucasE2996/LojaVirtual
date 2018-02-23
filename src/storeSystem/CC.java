package storeSystem;

public class CC extends Pagamento {

    private final String numeroCartao;
    private final int parcelas;

    public CC(String numeroCartao, int parcelas) {
        super(TipoPagamento.CC);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
    }

    @Override
    void validarPagamento() {
        validarCartao(numeroCartao, parcelas);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    private void validarCartao(String numeroCartao, int parcelas) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
    }
}
