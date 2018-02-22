package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public class Login {
    private FakeDB db;

    public Login(FakeDB db) {
        this.db = db;
    }

    public void validarCliente(int id) {
        db.getClientes().stream()
                .filter(cliente1 -> cliente1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
