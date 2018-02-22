package storeSystem;

public abstract class Pagamento {

    private final TipoPagamento tipo;
    private final double valor;
    boolean isValido = false;

    Pagamento(TipoPagamento tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    abstract boolean validarPagamento();

    public TipoPagamento getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
