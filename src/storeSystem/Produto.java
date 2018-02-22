package storeSystem;

public class Produto {
    private final double preco;
    private final String nome;

    public Produto(double preco, String nome) {
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
