import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho addProduto(Produto produto) {
        produtos.add(produto);
        return this;
    }

    public Carrinho build() {
        return this;
    }
}
