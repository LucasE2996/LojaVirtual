package pagamento;

public class CC extends Pagamento {

    private final int numeroCartao, parcelas;

    public CC(int numeroCartao, int parcelas) {
        super("CC");
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean validarPagamento() {
        return validarCartao(numeroCartao, parcelas);
    }

    private boolean validarCartao(int numeroCartao, int parcelas) {
        // codigo de validação do cartão, seria integrado ao sistema bancario
        return true;
    }
}
