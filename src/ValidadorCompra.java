public class ValidadorCompra {
    private final Compra compra;


    public ValidadorCompra(Compra compra) {
        this.compra = compra;
    }

    public boolean validarCompra() {
        return compra.getPagamento().validarPagamento();
    }
}
