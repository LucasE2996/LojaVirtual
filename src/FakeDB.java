import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class FakeDB {
    private List<Produto> produtos;
    private List<Cliente> clientes;

    public FakeDB() {
        produtos = new LinkedList<>();
        clientes = new LinkedList<>();
    }

    public void addCliente(int id) {
        clientes.add(new Cliente(id));
    }

    public void addProduto(double preco, String nome) {
        produtos.add(new Produto(preco, nome));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equals(nome))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
