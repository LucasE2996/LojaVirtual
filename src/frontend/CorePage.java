package frontend;

import storeSystem.*;
import database.*;

import java.util.Scanner;

public class CorePage {

    private final Scanner scanner;
    private final FakeDB DB;
    private Carrinho carrinho;

    public CorePage() {
        scanner  = new Scanner(System.in);
        DB =  new FakeDB();
        carrinho = new Carrinho();
        iniciarBd();
    }

    // exemplo de banco de dados
    private void iniciarBd() {
        DB.addCliente(1);
        DB.addCliente(2);
        DB.addCliente(3);
        DB.addProduto(45.99, "mouse");
        DB.addProduto(210.50, "teclado");
        DB.addProduto(150.67, "headset");
    }

    public void mainRouteene() {
        System.out.println("Esses sao os produtos disponiveis: ");
        DB.getProdutos().forEach(produto -> System.out.println(produto.getNome()));

        System.out.println("Digite o nome do produto que deseja adicionar, e a quantidade: [0 para finalizar compra]");
        int number = 1;
        while (number != 0) {
            System.out.println("Novo produto:");
            addProduto(scanner.next().trim(), scanner.nextInt());
            System.out.println("Para finalizar compra digite 0, caso queira comprar novamente digite outro numero");
            number = scanner.nextInt();
        }

        System.out.println("Seu carrinho de compras:");
        carrinho.getProdutos().forEach(produto -> System.out.println(produto.getNome()));

        checkoutRouteene();
    }

    private void checkoutRouteene() {
        Pagamento pagamento = null;
        GerenciadorCompra gerenciador = new GerenciadorCompra(DB, carrinho);

        System.out.println("Digite o id do cliente(login): ");
        int idCliente = scanner.nextInt();
        gerenciador.validarCliente(idCliente);

        System.out.println("Insira a forma de pagamento:");
        String tipo = scanner.next();

        // substituir por menu de opçoes de pagamento (Map <key, tipo de pagamento>)
        if (tipo.equals("boleto")) {
            Boleto boleto = new Boleto(gerenciador.getValordaCompra());
            System.out.println("Código do boleto: " + boleto.getCodigo());
            pagamento = boleto;
        } else if (tipo.equals("CC")) {
            System.out.println("Numero do Cartão:");
            String numCartao = scanner.next();
            System.out.println("Numero de parcelas");
            int parcelas = scanner.nextInt();
            CC cc = new CC(numCartao, gerenciador.getValordaCompra(), parcelas);
            pagamento = cc;
        }

        System.out.println("Tipo de pagamento: " + pagamento.getTipo() + "\nValor total da compra: " + pagamento.getValor());

        if (gerenciador.validarCompra(pagamento)) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Ops! Algo deu errado");
        }
    }

    private void addProduto(String produto, int qtd) {
        Produto novoProduto = DB.getProduto(produto);
        for (int i = 0; i < qtd; i++) {
            carrinho.addProduto(novoProduto);
        }
    }
}
