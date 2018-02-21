public class Boleto extends Pagamento{
    private final double codigo;

    public Boleto() {
        super("Boleto");
        this.codigo = gerarCodigo();
    }

    @Override
    public void validarPagamento() {
        System.out.println(codigo);
    }

    public double getCodigo() {
        return codigo;
    }

    private double gerarCodigo() {
        return Math.random()*10000;
    }
}
