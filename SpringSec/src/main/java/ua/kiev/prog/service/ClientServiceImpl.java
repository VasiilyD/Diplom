package ua.kiev.prog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.dao.ClientDao;
import ua.kiev.prog.model.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        this.clientDao.addClient(client);
    }

    @Override
    @Transactional
    public void updateClient(Client client) {
        this.clientDao.updateClient(client);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.clientDao.removeClient(id);
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return this.clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public List<Client> listClient() {
        return this.clientDao.listClient();
    }
}
