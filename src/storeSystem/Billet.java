package storeSystem;

public class Billet extends PaymentOption {
    private final int codigo;

    public Billet() {
        super(PaymentOptionType.BOLETO);
        this.codigo = gerarCodigo();
    }

    @Override
    void validarPagamento() {
        // codigo de validacao de pagamento no sistema bancario
    }

    public int getCodigo() {
        return codigo;
    }

    private int gerarCodigo() {
        return 1000000000 + (int)(Math.random() * 999999999);
    }
}
