/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Account;
import models.BankBranch;

/**
 *
 * @author MGU
 */
public class AccountDAO extends AbstractDAO<Account> {
    
    private static final AccountDAO instanceAccount = new AccountDAO();
    
    public static AccountDAO getInstance(){
        return instanceAccount;
    }
    
    public AccountDAO(){
        super();
    }   


    public Account find(String id) {
        return em.find(Account.class, id);
    }


    public List<Account> findAll() {
        List<Account> listAccounts = em.createQuery("select a from Account as a").getResultList();
        return listAccounts;
    }
    
    public List<Account> findAllByBranchId(BankBranch id){
        List<Account> listAccounts = em.createQuery("select a from Account as a where a.FK_ACCOUNT_BANKBRANCH_CODEAGENCE = "+id.getCodeAgence()).getResultList();
        return listAccounts;
    }
   
}
