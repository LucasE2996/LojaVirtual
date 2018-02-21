package pagamento;

public class Boleto extends Pagamento{
    private final int codigo;

    public Boleto(double valor) {
        super("Boleto", valor);
        this.codigo = gerarCodigo();
    }

    @Override
    public boolean validarPagamento() {
        imprimirCodigo();
        isValido = true;
        return isValido;
    }

    private void imprimirCodigo() {
        System.out.println("Código do boleto: " + codigo);
    }

    private int gerarCodigo() {
        return 1000000000 + (int)(Math.random() * 999999999);
    }
}
