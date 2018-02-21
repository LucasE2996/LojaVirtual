public class Main {
    public static void main(String[] args) {

        Cliente cliente01 = new Cliente(1);
        Cliente cliente02 = new Cliente(2);
        Cliente cliente03 = new Cliente(3);

        Produto produto01 = new Produto(45.99, "Mouse");
        Produto produto02 = new Produto(210.50, "Teclado");
        Produto produto03 = new Produto(150.67, "Headset");


        Compra compra = new Compra(1, cliente01,
                new CarrinhoBuilder().addProduto(produto01, 2).addProduto(produto02, 1).build(),
                new Boleto());

        ValidadorCompra validador = new ValidadorCompra(compra);
        validador.validarCompra();
    }
}
