package storeSystem;

public class CC extends Pagamento {

    private String numeroCartao;
    private int parcelas;

    CC(double valor) {
        super(TipoPagamento.CC, valor);
    }

    @Override
    boolean validarPagamento() {
        verificarCartao(numeroCartao, parcelas, getValor());
        return true;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    private void verificarCartao(String numeroCartao, int parcelas, double valor) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
    }
}
