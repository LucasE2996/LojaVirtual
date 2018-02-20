public abstract class Pagamento {

    String tipo;
    private boolean isValido = false;

    public Pagamento(String tipo) {
        this.tipo = tipo;
    }

    abstract void validarPagamento();

    public boolean isValido() {
        return isValido;
    }
}
