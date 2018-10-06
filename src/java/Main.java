

import DAO.ClientDAO;
import DAO.DAO;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import models.Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MGU
 */
public class Main {
    public static void main(String args[]){
    /*EntityManager em;
    EntityManagerFactory emf;
    EntityTransaction transac;
    emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
    em = emf.createEntityManager();
    transac = em.getTransaction();
    transac.begin();
    Client client = new Client();
    client.setNom("Barbier");
    client.setPrenom("Thomas");
    Date date = new Date("12/06/1991");
    client.setNaissance(date);
    em.persist(client);
    transac.commit();
    em.close();
    emf.close();*/
    DAO dao = new ClientDAO();
    Client client = new Client();
    client.setNom("Kervarec");
    client.setPrenom("Samuel");
    Date date = new Date("12/06/1991");
    client.setNaissance(date);
    dao.create(client);
    System.out.println("Test");
    
    
    
    
    
    }
    
}
