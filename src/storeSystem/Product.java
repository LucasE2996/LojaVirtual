package storeSystem;

public class Product {
    private float preco;
    private final String nome;

    public Product(float preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }
}
