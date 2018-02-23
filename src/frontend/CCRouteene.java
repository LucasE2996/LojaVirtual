package frontend;

import storeSystem.CC;
import storeSystem.GerenciadorCompra;

import java.util.Scanner;

public class CCRouteene implements CheckoutRouteene {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(GerenciadorCompra gerenciador) {
        System.out.printf("Valor toal da compra: %.2f" + "\n", gerenciador.getValordaCompra());
        System.out.println("Numero do Cartão:");
        String numCartao = scanner.next();
        System.out.println("Numero de parcelas");
        int parcelas = scanner.nextInt();
        CC cc = new CC(numCartao, parcelas);
        gerenciador.validarCompra(cc);
    }
}
