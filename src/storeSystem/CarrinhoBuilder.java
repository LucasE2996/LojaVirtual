package storeSystem;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoBuilder {
    private final List<Produto> produtos;

    public CarrinhoBuilder() {
        produtos = new ArrayList<>();
    }

    public CarrinhoBuilder addProduto(Produto produto, int qtd) {
        for (int i = 0; i < qtd; i++) {
            produtos.add(produto);
        }
        return this;
    }

    public Carrinho build() {
        return new Carrinho(/*carrinho*/);
    }
}
