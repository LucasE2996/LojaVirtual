package frontend;

import storeSystem.*;
import database.*;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorePage {

    private final Scanner scanner  = new Scanner(System.in);
    private final FakeDB DB;
    private final GerenciadorCompra gerenciador;
    private Carrinho carrinho;
    private HashMap<Integer, CheckoutRouteene> checkRouteenes = new HashMap<>();

    public CorePage() {
        DB =  new FakeDB();
        carrinho = new Carrinho();
        gerenciador = new GerenciadorCompra(DB, carrinho);
        checkRouteenes.put(1, new BoletoRouteene());
        checkRouteenes.put(2, new CCRouteene());
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

    // template method
    public void mainRouteene() {
        showProdutos();
        comprar();
        validarCliente();
        validarPagamento();
        System.out.println("Compra finalizada com sucesso!");
    }

    private void showProdutos() {
        System.out.println("Esses sao os produtos disponiveis: ");
        DB.getProdutos().forEach(produto -> System.out.println(produto.getNome()));
    }

    private void comprar() {
        System.out.println("Digite o nome do produto que deseja adicionar, e a quantidade: [0 para finalizar compra]");
        int number = 1;
        while (number != 0) {
            System.out.println("Novo produto:");
            addProduto(scanner.next().trim(), scanner.nextInt());
            System.out.println("Para finalizar compra digite 0, caso queira comprar novamente digite outro numero");
            number = scanner.nextInt();
        }

        System.out.println("Seu carrinho de compras:");
        HashMap<String, Integer> inventorio = new HashMap<>();
        for (Produto produto : carrinho.getProdutos()) {
            if (!inventorio.containsKey(produto.getNome())){
                inventorio.put(produto.getNome(), 1);
            } else {
                inventorio.put(produto.getNome(), inventorio.get(produto.getNome()) + 1);
            }
        }
        inventorio.forEach((key, value) -> System.out.println(key + "\tx" + value));
    }

    private void validarCliente() {
        System.out.println("Digite o id do cliente(login): ");
        int idCliente = 0;
        while (idCliente < 1 || idCliente > 3) {
            idCliente = scanner.nextInt();
        }
        gerenciador.validarCliente(idCliente);
    }

    private void validarPagamento() {
        System.out.println("Insira a forma de pagamento:\n[1] boleto\n[2] cartao de credito");
        int num = 0;
        while (num < 1 || num > 2) {
            num = scanner.nextInt();
        }
        runPagamento(num, gerenciador);
    }

    private void addProduto(String produto, int qtd) {
        Produto novoProduto = DB.getProduto(produto);
        for (int i = 0; i < qtd; i++) {
            carrinho.addProduto(novoProduto);
        }
    }

    private void runPagamento(int num, GerenciadorCompra gerenciador){
        checkRouteenes.entrySet().stream()
                .filter(routeene -> routeene.getKey() == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue()
                .run(gerenciador);
    }
}