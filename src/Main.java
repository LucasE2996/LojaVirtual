import pagamento.Boleto;
import pagamento.CC;
import pagamento.Pagamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // exemplo de banco de dados
        FakeDB DB = new FakeDB();
        DB.addCliente(1);
        DB.addCliente(2);
        DB.addCliente(3);
        DB.addProduto(45.99, "mouse");
        DB.addProduto(210.50, "teclado");
        DB.addProduto(150.67, "headset");

        // frontend
        Carrinho carrinho = new CarrinhoBuilder()
                .addProduto(DB.getProduto("mouse"), 2)
                .addProduto(DB.getProduto("teclado"), 1)
                .build();

        System.out.println("Carrinho de Compras:");
        carrinho.getProdutos().forEach(produto -> System.out.println(produto.getNome()));

        // rotina de checkout
        Scanner scanner = new Scanner(System.in);
        Pagamento pagamento = null;
        System.out.println("Insira o tipo de pagamento:");
        String tipo = scanner.next();
        if (tipo.equals("boleto")){
            pagamento = new Boleto();
        } else if (tipo.equals("CC")) {
            System.out.println("Numero do Cartão:");
            int numCartao = scanner.nextInt();
            System.out.println("Numero de parcelas");
            int parcelas = scanner.nextInt();
            pagamento = new CC(numCartao, parcelas);
        }

        GerenciadorCompra gerenciador = new GerenciadorCompra(DB, carrinho, pagamento);
        gerenciador.validarCompra(1, "Boleto");

        DB.getClientes().get(0).getCompras()
                .forEach(compra -> System.out.println(compra.getDescricao()));
    }
}
