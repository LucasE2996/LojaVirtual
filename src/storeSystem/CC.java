package storeSystem;

public class CC extends Pagamento {

    private String numeroCartao;
    private int parcelas;

    CC(double valor) {
        super(TipoPagamento.CC, valor);
    }

    @Override
    boolean validarPagamento() {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
        return true;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
