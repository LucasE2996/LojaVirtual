package storeSystem;

public class CC extends Pagamento {

    private final String numeroCartao;
    private final int parcelas;

    CC(double valor, String numeroCartao, int parcelas) {
        super(TipoPagamento.CC, valor);
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
    }

    @Override
    boolean validarPagamento() {
        verificarCartao(numeroCartao, parcelas, getValor());
        return true;
    }

    private void verificarCartao(String numeroCartao, int parcelas, double valor) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
    }
}
