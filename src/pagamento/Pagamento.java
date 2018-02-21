package pagamento;

public abstract class Pagamento {

    private final String tipo;
    boolean isValido = false;

    Pagamento(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean validarPagamento();

    public String getTipo() {
        return tipo;
    }
}
