public class Compra {
    private final int id;
    private final Carrinho carrinho;
    private final Pagamento pagamento;

    public Compra(int id, Cliente cliente, Carrinho carrinho, Pagamento pagamento) {
        this.id = id;
        this.carrinho = carrinho;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
