package storeSystem;

public class Item {
    private int quantity;
    private Product product;

    Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    float getTotal() {
        return product.getPreco() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return product.getNome();
    }
}
