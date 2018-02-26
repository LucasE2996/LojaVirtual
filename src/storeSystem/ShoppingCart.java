package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private  List<Item> items = new LinkedList<>();

   public void addItem(Product product, int quantity) {
       items.add(new Item(product, quantity));
   }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public float getValor() {
       float sum = 0;
        for (Item item: items) {
            sum += item.getTotal();
        }
        return sum;
    }
}
