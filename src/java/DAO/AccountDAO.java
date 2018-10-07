/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.Account;

/**
 *
 * @author MGU
 */
public class AccountDAO extends AbstractDAO {
    
    private EntityManager em;
    private EntityManagerFactory emf;
    
    public AccountDAO(){
        super();
    }   

    @Override
    public Object find(int id) {
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        List<Account> listAccounts = em.createQuery("Select * FROM Account").getResultList();
        return listAccounts;
    }
   
}
