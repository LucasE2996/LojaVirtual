package pagamento;

public abstract class Pagamento {

    private final String tipo;
    private final double valor;
    boolean isValido = false;

    Pagamento(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public abstract boolean validarPagamento();

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
