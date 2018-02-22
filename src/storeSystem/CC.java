package storeSystem;

public class CC extends Pagamento {

    private final int numeroCartao, parcelas;

    public CC(int numeroCartao, double valor, int parcelas) {
        super(TipoPagamento.CC, valor);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
    }

    @Override
    boolean validarPagamento() {
        return validarCartao(numeroCartao, getValor(), parcelas);
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    private boolean validarCartao(int numeroCartao, double valor, int parcelas) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        // para fazer autenticação da transação
        return true;
    }
}
