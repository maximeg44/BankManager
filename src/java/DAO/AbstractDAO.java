/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MGU
 */
public abstract class AbstractDAO<T> {
    protected EntityManager em;
    protected EntityManagerFactory emf;
    
    
    public AbstractDAO(){
        emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
        em = emf.createEntityManager();
    }
    

    /**
     * Méthode qui permet de créer un objet T.
     * @param objet l'objet à créer.
     */
    public void create(T objet) {
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
    }
    
    /**
     * Méthode qui permet de mettre à jour un objet T.
     * @param obj l'objet à mettre à jour.
     */
    public void update(T obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }
    
    /**
     * Méthode qui permet de supprimer un objet T.
     * @param obj l'objet à supprimer.
     */
    public void delete(T obj) {
        em.getTransaction().begin();
        try{
            em.remove(obj);
        }catch(Exception e){
            System.out.println(e);
        }
        em.getTransaction().commit();
    }
 
}
