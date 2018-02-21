public abstract class Pagamento {

    private final String tipo;
    private boolean isValido = false;

    protected Pagamento(String tipo) {
        this.tipo = tipo;
    }

    public void validarPagamento() { // ideal seria ser abstract method, porem preciso de acesso ao isValido;
        isValido = true;
    }

    public boolean isValido() {
        return isValido;
    }

    public String getTipo() {
        return tipo;
    }
}
