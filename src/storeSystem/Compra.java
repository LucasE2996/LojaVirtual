package storeSystem;

public class Compra {
    private final int id;
    private final Carrinho carrinho;
    private double valor;

    Compra(int id, Carrinho carrinho) {
        this.id = id;
        this.carrinho = carrinho;
        setValor();
    }

    public int getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public double getValor() {
        return valor;
    }

    private void setValor() {
        valor = getCarrinho().getValor();
    }
}
