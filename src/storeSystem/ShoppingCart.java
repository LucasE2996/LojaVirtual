package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private  List<Product> products = new LinkedList<>();

   public void addProduto(Product product) {
       products.add(product);
   }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public float getValor() {
        return (float) getProducts().stream().mapToDouble(Product::getPreco).sum();
    }
}
