package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public class GerenciadorCompra {
    private final Carrinho carrinho;
    private final FakeDB DB;
    private Cliente cliente;

    public GerenciadorCompra(FakeDB DB, Carrinho carrinho) {
        this.DB = DB;
        this.carrinho = carrinho;
    }

    public void validarCompra(Pagamento pagamento) {
        validarPagamento(pagamento);
        addCompraToCliente(pagamento);
    }

    public void validarCliente(int id) {
        this.cliente = DB.getClientes().stream()
                .filter(cliente1 -> cliente1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public double getValordaCompra() {
        return carrinho.getValor();
    }

    private void addCompraToCliente(Pagamento pagamento) {
        Compra compra = new Compra( carrinho.getProdutos(), carrinho.getValor(),pagamento);
        cliente.addCompra(compra);
    }

    private void validarPagamento(Pagamento pagamento) {
        pagamento.validarPagamento();
    }
}
