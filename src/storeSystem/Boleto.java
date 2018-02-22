package storeSystem;

public class Boleto extends Pagamento {
    private final int codigo;

    public Boleto(double valor) {
        super(TipoPagamento.BOLETO, valor);
        this.codigo = gerarCodigo();
    }

    @Override
    boolean validarPagamento() {
        // codigo de validacao de pagamento no sistema bancario
        isValido = true;
        return isValido;
    }

    public int getCodigo() {
        return codigo;
    }

    private int gerarCodigo() {
        return 1000000000 + (int)(Math.random() * 999999999);
    }
}
