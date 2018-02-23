package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Carrinho {
    private  List<Produto> produtos = new LinkedList<>();

   public void addProduto(Produto produto) {
       produtos.add(produto);
   }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public float getValor() {
        return (float)getProdutos().stream().mapToDouble(Produto::getPreco).sum();
    }
}
