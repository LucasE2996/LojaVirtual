package storeSystem;

public class Compra {
    private final int id;
    private final String descricao;
    private final Carrinho carrinho;
    private final Pagamento pagamento;
    private double valor;

    Compra(int id, Carrinho carrinho, Pagamento pagamento, String descricao) {
        this.id = id;
        this.carrinho = carrinho;
        this.pagamento = pagamento;
        this.descricao = descricao;
        setValor();
    }

    public int getId() {
        return id;
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

    public double getValor() {
        return valor;
    }

    private void setValor() {
        valor = getCarrinho().getValor();
    }
}
