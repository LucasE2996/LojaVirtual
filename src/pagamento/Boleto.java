package pagamento;

public class Boleto extends Pagamento{
    private final int codigo;

    public Boleto() {
        super("Boleto");
        this.codigo = gerarCodigo();
    }

    @Override
    public boolean validarPagamento() {
        System.out.println(codigo);
        isValido = true; // in a real case, this method would have other functionality
        return isValido;
    }

    public int getCodigo() {
        return codigo;
    }

    private int gerarCodigo() {
        return 1000000000 + (int)(Math.random() * 999999999);
    }
}
