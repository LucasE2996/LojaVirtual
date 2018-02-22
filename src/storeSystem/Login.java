package storeSystem;

import com.sun.deploy.util.SessionState;
import database.FakeDB;

import java.util.NoSuchElementException;

public class Login {
    private FakeDB db;

    public Login(FakeDB db) {
        this.db = db;
    }

    public Cliente validarCliente(int id) {
        return db.getClientes().stream()
                .filter(cliente1 -> cliente1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
