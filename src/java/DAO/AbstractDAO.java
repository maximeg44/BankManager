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
    
    
    public AbstractDAO(){
        emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void create(Object objet) {
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
    }
    
    public void update(Object obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }
    
    public void delete(Object obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }
    
    
}
