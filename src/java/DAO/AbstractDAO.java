/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author MGU
 */
public abstract class AbstractDAO implements DAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    EntityTransaction transac;
    
    public AbstractDAO(){
        emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();
    }
    
    @Override
    public void create(Object objet) {
        em.persist(objet);
        transac.commit();
        em.close();
        emf.close();
        
    }
    
    public void update(Object obj) {
        
    }
    
    public void delete(Object obj) {
        
    }
    
    
}
