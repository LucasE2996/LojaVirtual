public class Compra {
    private final int id;
    private final Carrinho carrinho;
    private int parcelas;
    private Pagamento pagamento;

    public Compra(int id, Cliente cliente, Carrinho carrinho, int parcelas) {
        this.id = id;
        this.carrinho = carrinho;
        this.parcelas = parcelas;
    }

    public int getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public int getParcelas() {
        return parcelas;
    }
}
