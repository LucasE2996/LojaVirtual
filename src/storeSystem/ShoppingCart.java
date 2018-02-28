package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
    private  List<Item> items = new LinkedList<>();

   public void addItem(Product product, int quantity) {
        final Optional<Item> item = items.stream()
                .filter(item1 -> item1.getProductName()
                        .equals(product.getNome())).findFirst();
        if(item.isPresent()) {
            item.get().increment(quantity);
        } else {
            items.add(new Item(product, quantity));
        }
   }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public float getValor() {
       return (float)items.stream().mapToDouble(Item::getTotal).sum();
    }

    public void clear() {
       items.clear();
    }
}
