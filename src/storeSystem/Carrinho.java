package storeSystem;

import java.util.Collections;
import java.util.List;

public class Carrinho {
    private final List<Produto> produtos;
    private double valor;

   Carrinho(List<Produto> produtos){
       this.produtos = produtos;
   }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public Produto getProduto(String nome) {
       return produtos.stream()
               .filter(produto -> produto.getNome().equals(nome))
               .findFirst()
               .get();
    }

    private void calcValor() {
        getProdutos().forEach(produto -> valor += produto.getPreco());
    }

    public double getValor() {
        return valor;
    }
}
