package storeSystem;

public abstract class Pagamento {

    private final TipoPagamento tipo;
    private final double valor;

    Pagamento(TipoPagamento tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    abstract boolean validarPagamento();

    public TipoPagamento getTipo() {
        return tipo;
    }

    double getValor() {
        return valor;
    }
}
