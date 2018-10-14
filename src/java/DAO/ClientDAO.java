/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Client;

/**
 * ClientDAO qui étend la classe abstraite du DAO.
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

    /**
     * Méthode pour chercher un client en fonction de son identifiant.
     * @param id l'id du client à chercher.
     * @return le client cherché.
     */
    public Client find(String id) {
        return em.find(Client.class, id);
    }

    /**
     * Méthode qui retourne la liste de tous les clients présents en base.
     * @return la liste de tous les clients présents en base.
     */
    public List<Client> findAll() {
        List<Client> listClients = em.createQuery("select c from Client as c").getResultList();
        return listClients;
    }
    
}
