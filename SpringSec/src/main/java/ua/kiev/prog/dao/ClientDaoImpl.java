package ua.kiev.prog.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.Client;

import java.util.List;


@Repository
public class ClientDaoImpl implements ClientDao {
    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClient(Client client) {
        Session session =this.sessionFactory.getCurrentSession();
        session.persist(Client.class);
        logger.info("add client sucsses" + client);
    }

    @Override
    public void updateClient(Client client) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(client);
        logger.info("update " + client);

    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client client = (Client) session.load(Client.class, new Integer(id));

        if (client!=null){
            session.delete(client);
        }
        logger.info("delete"+ client);
    }

    @Override
    public Client getClientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client client = (Client) session.load(Client.class, new Integer(id));
        logger.info("Client Load "+ client);

        return client;
    }

    @Override
    public List<Client> listClient() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Client> clientList = session.createQuery("from Client").list();

        for (Client client : clientList){
            logger.info("Client List"+ client);
        }

        return clientList;
    }
}
