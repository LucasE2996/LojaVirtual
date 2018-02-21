package pagamento;

public class Boleto extends Pagamento{
    private final int codigo;

    public Boleto() {
        super("Boleto");
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
