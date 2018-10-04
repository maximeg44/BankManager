/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author MGU
 */
public class ClientDAO implements DAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    
    

    @Override
    public void create(Object objet) {
        this.emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
        this.em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(objet);
        transac.commit();
        em.close();
        emf.close();        
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
