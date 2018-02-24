package storeSystem;

public class CreditCard extends PaymentOption {

    private final String numeroCartao;
    private final int parcelas;

    public CreditCard(String numeroCartao, int parcelas) {
        super(PaymentOptionType.CC);
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
