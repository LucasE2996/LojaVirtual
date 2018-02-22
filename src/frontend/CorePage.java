package frontend;

import storeSystem.*;
import database.*;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorePage {

    private final Scanner scanner;
    private final FakeDB DB;
    private Carrinho carrinho;
    private HashMap<Integer, TipoPagamento> formaDePagamento;

    public CorePage() {
        scanner  = new Scanner(System.in);
        DB =  new FakeDB();
        carrinho = new Carrinho();
        formaDePagamento = new HashMap<>();
        formaDePagamento.put(1, TipoPagamento.BOLETO);
        formaDePagamento.put(2, TipoPagamento.CC);
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
        Login login = new Login(DB);

        System.out.println("Digite o id do cliente(login): ");
        int idCliente = scanner.nextInt();
        Cliente loggedClient = login.validarCliente(idCliente);

        System.out.println("Insira a forma de pagamento:\n[1]boleto\n[2]cartão de crrédito");
        int opcao = scanner.nextInt();
        TipoPagamento tipo = selecionarPagamento(opcao);
        GerenciadorCompra gerenciador;

        if(tipo.equals(TipoPagamento.CC)) {
            System.out.println("Digite o numero do cartão:");
            String numCartao = scanner.next();
            System.out.println("Digite o numero de parcelas:");
            int parcelas = scanner.nextInt();
            gerenciador = new GerenciadorCompraCC(carrinho, loggedClient, numCartao, parcelas);
            gerenciador.validarCompra(tipo);
            printValorTotal(gerenciador.getValorCompra());
        } else if(tipo.equals(TipoPagamento.BOLETO)) {
            GerenciadorCompraBoleto gerenciadorBoleto = new GerenciadorCompraBoleto(carrinho, loggedClient);
            gerenciador = gerenciadorBoleto;
            gerenciador.validarCompra(tipo);
            System.out.println("Codigo do boleto: " + gerenciadorBoleto.getCodigo());
            printValorTotal(gerenciador.getValorCompra());
        }
    }

    private void addProduto(String produto, int qtd) {
        Produto novoProduto = DB.getProduto(produto);
        for (int i = 0; i < qtd; i++) {
            carrinho.addProduto(novoProduto);
        }
    }

    private TipoPagamento selecionarPagamento(int valor) {
        return formaDePagamento.entrySet().stream()
                .filter(value -> value.getKey() == valor)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue();
    }

    private void printValorTotal(double valor) {
        System.out.println("Valor total da compra: R$" + valor);
    }
}
