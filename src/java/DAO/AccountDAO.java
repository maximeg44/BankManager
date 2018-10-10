/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Account;

/**
 *
 * @author MGU
 */
public class AccountDAO extends AbstractDAO {
    
    
    public AccountDAO(){
        super();
    }   

    @Override
    public Account find(int id) {
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        List<Account> listAccounts = em.createQuery("select a from Account as a").getResultList();
        return listAccounts;
    }
   
}
