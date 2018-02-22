package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public abstract class GerenciadorCompra {
    private final Carrinho carrinho;
    private final FakeDB DB;
    private Cliente cliente;

    public GerenciadorCompra(FakeDB DB, Carrinho carrinho) {
        this.DB = DB;
        this.carrinho = carrinho;
    }

    public boolean validarCompra(TipoPagamento tipo) {
        Pagamento pagamento = createPagamento(tipo, carrinho.getValor());
        addCompraToCliente(pagamento);
        return true;
    }

    public void validarCliente(int id) {

    }

    public double getValordaCompra() {
        return carrinho.getValor();
    }

    private void addCompraToCliente(Pagamento pagamento) {
        final int novoId = cliente.getCompras().size() + 1;
        Compra compra = new Compra(novoId, carrinho, pagamento);
        cliente.addCompra(compra);
    }

    // factory method
    abstract Pagamento createPagamento(TipoPagamento tipo, double value);
}
