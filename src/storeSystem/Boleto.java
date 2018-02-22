package storeSystem;

public class Boleto extends Pagamento {
    private final String codigo;

    Boleto(double valor) {
        super(TipoPagamento.BOLETO, valor);
        this.codigo = gerarCodigo();
    }

    @Override
    boolean validarPagamento() {
        // codigo de validacao de pagamento no sistema bancario
        return true;
    }

    public String getCodigo() {
        return codigo;
    }

    private String gerarCodigo() {
        return Integer.toString(1000000000 + (int)(Math.random() * 999999999));
    }
}
