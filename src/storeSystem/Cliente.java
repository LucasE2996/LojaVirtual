package storeSystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private final int id;
    private List<Compra> compras;

    public Cliente(int id) {
        this.id = id;
        compras = new LinkedList<>();
    }

    void addCompra(Compra compra) {
        compras.add(compra);
    }

    public int getId() {
        return id;
    }

    public List<Compra> getCompras() {
        return Collections.unmodifiableList(compras);
    }
}
