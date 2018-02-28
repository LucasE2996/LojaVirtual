package frontend;

import storeSystem.*;
import database.*;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorePage {

    private final Scanner scanner  = new Scanner(System.in); //delegar a outra classe
    private final FakeDB DB;
    private final OrderManager manager;
    private final Login login;
    private final ClientPage clientPage;
    private Client loggedClient;
    private ShoppingCart shoppingCart;
    private HashMap<Integer, CheckoutRoutine> checkRoutines = new HashMap<>();

    public CorePage() {
        DB =  new FakeDB();
        shoppingCart = new ShoppingCart();
        manager = new OrderManager(shoppingCart);
        login = new Login();
        clientPage = new ClientPage();
        checkRoutines.put(1, new BilletRoutine());
        checkRoutines.put(2, new CCRoutine());
        iniciarBd();
    }

    // database exemple
    private void iniciarBd() {
        DB.addCliente(1);
        DB.addCliente(2);
        DB.addCliente(3);
        DB.addProduto(45, "mouse");
        DB.addProduto(210, "teclado");
        DB.addProduto(150, "headset");
    }

    // template method
    public void mainRouteene() {
        showProdutos();
        comprar();
        validateClient();
        validatePayment();
        System.out.println("Compra finalizada com sucesso!");
        clientPage.run(loggedClient);
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
            addItem(scanner.next().trim(), scanner.nextInt());
            System.out.println("Para finalizar compra digite 0, caso queira comprar novamente digite outro numero");
            number = scanner.nextInt();
        }

        System.out.println("Seu carrinho de compras:");
        for (Item item: shoppingCart.getItems()) {
            System.out.println(item.getProductName() + "\tx" + item.getQuantity());
        }

    }

    private void validateClient() {
        System.out.println("Digite o id do cliente(login): ");
        int clientID = 0;
        while (clientID < 1 || clientID > 3) { //"validacao"
            clientID = scanner.nextInt();
        }
        loggedClient = login.validarCliente(clientID, DB);
    }

    private void validatePayment() {
        System.out.println("Insira a forma de pagamento:\n[1] boleto\n[2] cartao de credito");
        int num = 0;
        while (num < 1 || num > 2) {
            num = scanner.nextInt();
        }
        runPagamento(num, manager);
    }

    private void addItem(String produto, int qtd) {
        shoppingCart.addItem(DB.getProduct(produto), qtd);
    }

    private void runPagamento(int num, OrderManager manager) {
        checkRoutines.entrySet().stream()
                .filter(routeene -> routeene.getKey() == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue()
                .run(manager, loggedClient, shoppingCart);
    }
}