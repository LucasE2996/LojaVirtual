package storeSystem;

public abstract class Pagamento {

    private final TipoPagamento tipo;

    Pagamento(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    abstract void validarPagamento();

    public TipoPagamento getTipo() {
        return tipo;
    }
}
