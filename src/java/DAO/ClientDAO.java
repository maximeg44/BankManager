/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Client;
/**
 *
 * @author MGU
 */
public class ClientDAO extends AbstractDAO<Client> {
    
    private static final ClientDAO instanceC = new ClientDAO();
    
    public static ClientDAO getInstance(){
        return instanceC;
    }
    public ClientDAO(){
        super();
    }   

    public Client find(String id) {
        return em.find(Client.class, id);
    }

    public List<Client> findAll() {
        List<Client> listClients = em.createQuery("select c from Client as c").getResultList();
        return listClients;
    }
    
}
