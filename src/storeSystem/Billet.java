package storeSystem;

public class Billet extends PaymentOption {
    private final int codigo;

    public Billet(int codigo) {
        super(PaymentOptionType.BOLETO);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
