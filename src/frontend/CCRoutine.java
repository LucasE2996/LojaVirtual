package frontend;

import storeSystem.Client;
import storeSystem.CreditCard;
import storeSystem.OrderManager;
import storeSystem.ShoppingCart;

import java.util.Scanner;

public class CCRoutine implements CheckoutRoutine {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(OrderManager gerenciador, Client client, ShoppingCart shoppingCart) {
        System.out.printf("Valor toal da compra: %.2f" + "\n", shoppingCart.getValor());
        System.out.println("Numero do Cartão:");
        String numCartao = scanner.next();
        System.out.println("Numero de parcelas");
        int parcelas = scanner.nextInt();
        CreditCard creditCard = new CreditCard(numCartao, parcelas);
        gerenciador.addCompraToClient(creditCard, client);
    }
}
