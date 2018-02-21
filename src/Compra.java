import pagamento.Pagamento;

public class Compra {
    private final int id;
    private final String descricao;
    private final Carrinho carrinho;
    private final Pagamento pagamento;
    private double valor;

    public Compra(int id, Carrinho carrinho, Pagamento pagamento, String descricao) {
        this.id = id;
        this.carrinho = carrinho;
        this.pagamento = pagamento;
        this.descricao = descricao;
        calcValor();
    }

    public String getDescricao() {
        return descricao;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    private void setPagamento(String tipoDePagamento) {

    }

    private void calcValor() {
        carrinho.getProdutos().forEach(produto -> valor += produto.getPreco());
    }
}
