package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Carrinho {
    private  List<Produto> produtos = new LinkedList<>();
    private double valor;

   public void addProduto(Produto produto) {
       produtos.add(produto);
       calcValor();
   }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public double getValor() {
        return valor;
    }

    private void calcValor() {
        valor = getProdutos().stream().mapToDouble(Produto::getPreco).sum();
    }
}
