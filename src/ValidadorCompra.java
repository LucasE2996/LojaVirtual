public class ValidadorCompra {
    private final Compra compra;


    public ValidadorCompra(Compra compra) {
        this.compra = compra;
    }

    public boolean validarCompra() {
        compra.getPagamento().validarPagamento();
        return compra.getPagamento().isValido();
    }
}
