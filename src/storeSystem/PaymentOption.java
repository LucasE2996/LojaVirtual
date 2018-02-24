package storeSystem;

public abstract class PaymentOption {

    private final PaymentOptionType tipo;

    PaymentOption(PaymentOptionType tipo) {
        this.tipo = tipo;
    }

    abstract void validarPagamento();

    public PaymentOptionType getTipo() {
        return tipo;
    }
}
