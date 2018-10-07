/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.Client;
/**
 *
 * @author MGU
 */
public class ClientDAO extends AbstractDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    
    public ClientDAO(){
        super();
    }   

    @Override
    public Object find(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        List<Client> listClients = em.createQuery("Select * FROM Client").getResultList();
        return listClients;

    }
    
}
