package storeSystem;

public class Product {
    private double preco;
    private final String nome;

    public Product(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
