package ua.kiev.prog.dao;

import ua.kiev.prog.model.Client;

import java.util.List;

public interface ClientDao {
    public void addClient (Client client);
    public void updateClient  (Client client);
    public void removeClient (int id);
    public Client getClientById(int id);

    public List<Client> listClient();

}
