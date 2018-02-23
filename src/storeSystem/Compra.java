package storeSystem;

import java.util.Collections;
import java.util.List;

public class Compra {
    private final List<Produto> produtos;
    private final Pagamento pagamento;
    private float valor;

    Compra(List<Produto> produtos, float valor,Pagamento pagamento) {
        this.produtos = produtos;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public List<Produto> produtos() {
        return Collections.unmodifiableList(produtos);
    }

    public Pagamento getPagamentoTipo() {
        return pagamento;
    }

    public float getValorCompra() {
        return valor;
    }
}
