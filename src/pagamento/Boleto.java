package pagamento;

public class Boleto extends Pagamento{
    private final int codigo;

    public Boleto(double valor) {
        super("Boleto", valor);
        this.codigo = gerarCodigo();
    }

    @Override
    public boolean validarPagamento() {
        isValido = true;
        return isValido;
    }

    public int getCodigo() {
        return codigo;
    }

    private int gerarCodigo() {
        return 1000000000 + (int)(Math.random() * 999999999);
    }
}
