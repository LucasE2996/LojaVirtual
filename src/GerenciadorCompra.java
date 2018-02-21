
import pagamento.Pagamento;

import java.util.NoSuchElementException;

public class GerenciadorCompra {
    private final Carrinho carrinho;
    private Cliente cliente;
    private final FakeDB DB;

    private Compra compra;

    public GerenciadorCompra(FakeDB DB, Carrinho carrinho) {
        this.DB = DB;
        this.carrinho = carrinho;
    }

    public boolean validarCompra(Pagamento pagamento) {
        validarPagamento(pagamento);
        addCompraToCliente(pagamento);
        return true;
    }

    public void validarCliente(int id) {
        this.cliente = DB.getClientes().stream()
                .filter(cliente1 -> cliente1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private void addCompraToCliente(Pagamento pagamento) {
        final int novoId = cliente.getCompras().size() + 1;
        final String novaDescricao = "Compra nº" + (novoId);
        compra = new Compra(novoId, carrinho, pagamento, novaDescricao);
        cliente.addCompra(compra);
    }

    private void validarPagamento(Pagamento pagamento) {
        pagamento.validarPagamento();
    }
}
