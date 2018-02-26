package storeSystem;

import database.FakeDB;

import java.util.NoSuchElementException;

public class Login {

    public Client validarCliente(int id, FakeDB db) {
        return db.getClients().stream()
                .filter(client1 -> client1.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
