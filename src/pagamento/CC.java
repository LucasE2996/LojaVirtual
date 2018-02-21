package pagamento;

public class CC extends Pagamento {
    private final int numero;

    public CC(int numero) {
        super("CC");
        this.numero = numero;
    }

    @Override
    public boolean validarPagamento() {
        isValido = true; // in a real case, this method would have other functionality
        return isValido;
    }
}
