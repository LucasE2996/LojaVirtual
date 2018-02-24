package frontend;

import storeSystem.*;
import database.*;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorePage {

    private final Scanner scanner  = new Scanner(System.in);
    private final FakeDB DB;
    private final OrderManager manager;
    private ShoppingCart shoppingCart;
    private HashMap<Integer, CheckoutRoutine> checkRoutines = new HashMap<>();

    public CorePage() {
        DB =  new FakeDB();
        shoppingCart = new ShoppingCart();
        manager = new OrderManager(DB, shoppingCart);
        checkRoutines.put(1, new BilletRoutine());
        checkRoutines.put(2, new CCRoutine());
        iniciarBd();
    }

    // database exemple
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
        validateClient();
        validatePayment();
        System.out.println("Compra finalizada com sucesso!");
    }

    private void showProdutos() {
        System.out.println("Esses sao os produtos disponiveis: ");
        DB.getProducts().forEach(product -> System.out.println(product.getNome()));
    }

    private void comprar() {
        System.out.println("Digite o nome do produto que deseja adicionar, e a quantidade: [0 para finalizar compra]");
        int number = 1;
        while (number != 0) {
            System.out.println("Novo produto:");
            addProduct(scanner.next().trim(), scanner.nextInt());
            System.out.println("Para finalizar compra digite 0, caso queira comprar novamente digite outro numero");
            number = scanner.nextInt();
        }

        System.out.println("Seu carrinho de compras:");
        HashMap<String, Integer> inventorio = new HashMap<>();
        for (Product product : shoppingCart.getProducts()) {
            if (!inventorio.containsKey(product.getNome())){
                inventorio.put(product.getNome(), 1);
            } else {
                inventorio.put(product.getNome(), inventorio.get(product.getNome()) + 1);
            }
        }
        inventorio.forEach((key, value) -> System.out.println(key + "\tx" + value));
    }

    private void validateClient() {
        System.out.println("Digite o id do cliente(login): ");
        int clientID = 0;
        while (clientID < 1 || clientID > 3) {
            clientID = scanner.nextInt();
        }
        manager.validarCliente(clientID);
    }

    private void validatePayment() {
        System.out.println("Insira a forma de pagamento:\n[1] boleto\n[2] cartao de credito");
        int num = 0;
        while (num < 1 || num > 2) {
            num = scanner.nextInt();
        }
        runPagamento(num, manager);
    }

    private void addProduct(String produto, int qtd) {
        Product novoProduct = DB.getProduto(produto);
        for (int i = 0; i < qtd; i++) {
            shoppingCart.addProduto(novoProduct);
        }
    }

    private void runPagamento(int num, OrderManager manager){
        checkRoutines.entrySet().stream()
                .filter(routeene -> routeene.getKey() == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue()
                .run(manager);
    }
}