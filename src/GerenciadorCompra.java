
import pagamento.Pagamento;

import java.util.NoSuchElementException;

public class GerenciadorCompra {
    private final Pagamento pagamento;
    private final Carrinho carrinho;
    private Cliente cliente;
    private final FakeDB DB;

    private Compra compra;

    public GerenciadorCompra(FakeDB DB, Carrinho carrinho, Pagamento pagamento) {
        this.DB = DB;
        this.carrinho = carrinho;
        this.pagamento = pagamento;
    }

    // template method
    public boolean validarCompra(int idCliente, String tipoPagamento) {
        this.cliente = validarCliente(idCliente);
        validarPagamento();
        addCompraToCliente(tipoPagamento);
        return true;
    }

    private Cliente validarCliente(int id) {
        return DB.getClientes().stream()
                .filter(cliente1 -> cliente1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private void addCompraToCliente(String tipoPagamento) {
        final int novoId = cliente.getCompras().size() + 1;
        final String novoNome = "Compra nº" + (novoId);
        compra = new Compra(novoId, carrinho, pagamento, novoNome);
        cliente.addCompra(compra);
    }

    private void validarPagamento() {
        pagamento.validarPagamento();
    }
}
