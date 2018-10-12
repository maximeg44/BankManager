/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.Query;
import models.Compte;
import models.BankBranch;
import models.Client;

/**
 *
 * @author MGU
 */
public class AccountDAO extends AbstractDAO<Compte> {
    
    private static final AccountDAO instanceAccount = new AccountDAO();
    
    public static AccountDAO getInstance(){
        return instanceAccount;
    }
    
    public AccountDAO(){
        super();
    }   


    public Compte find(String id) {
        return em.find(Compte.class, id);
    }


    public List<Compte> findAll() {
        List<Compte> listAccounts = em.createQuery("select a from Compte as a").getResultList();
        return listAccounts;
    }
    
    public List<Compte> findAllByBranchId(BankBranch branch){
        List<Compte> listAccounts;
        Query query   = em.createQuery("select a from Compte as a where a.bankbranch = :branch");
        query.setParameter("branch",branch);
        listAccounts = query.getResultList();
        return listAccounts;
    }
   
}
