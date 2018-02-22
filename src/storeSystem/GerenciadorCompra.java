package storeSystem;

public abstract class GerenciadorCompra {
    private Carrinho carrinho;
    private Cliente cliente;

    public GerenciadorCompra(Carrinho carrinho, Cliente cliente) {
        this.carrinho = carrinho;
        this.cliente = cliente;
    }

    public boolean validarCompra(TipoPagamento tipo) {
        validarPagamento(tipo);
        addCompraToCliente();
        return true;
    }

    public double getValorCompra() {
        return carrinho.getValor();
    }

    private void addCompraToCliente() {
        final int novoId = cliente.getCompras().size() + 1;
        Compra compra = new Compra(novoId, carrinho);
        cliente.addCompra(compra);
    }

    abstract void validarPagamento(TipoPagamento tipo);

    Carrinho getCarrinho() {
        return carrinho;
    }
}
