package database;

import java.util.LinkedList;
import java.util.List;

import storeSystem.Product;
import storeSystem.Client;
import java.util.NoSuchElementException;

public class FakeDB {
    private List<Product> products;
    private List<Client> clients;

    public FakeDB() {
        products = new LinkedList<>();
        clients = new LinkedList<>();
    }

    public void addCliente(int id) {
        clients.add(new Client(id));
    }

    public void addProduto(double preco, String nome) {
        products.add(new Product(preco, nome));
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduto(String nome) {
        return products.stream()
                .filter(product -> product.getNome().equals(nome))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
