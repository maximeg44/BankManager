/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.util.Date;
import java.util.List;
import models.Account;
import models.BankBranch;
import models.Client;

/**
 *
 * @author MGU
 */
public class AccountControler {
    private AccountDAO accountDAO = AccountDAO.getInstance();
    
    
    public Account createAccount(String[] infoAccount){
        Account account = new Account();
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));        
        accountDAO.create(account);
        return account;        
    }
    
    public Account updateAccount(String[] infoAccount, String idAccount){
        Account account = findById(idAccount);
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));   
        accountDAO.update(account);
        
        return account;        
    }
    
    public Account updateAccount(Account account){
       accountDAO.update(account);
       return account;
       
    }
    
    public Account findById(String id){
        return accountDAO.find(id);
    }
    
    public List<Account> findAllAccounts(){
        return accountDAO.findAll();
    }
           
    public void removeAccount(Account account){
        accountDAO.delete(account);
    }
    
    public List<Account> findAllByBranchId(BankBranch codeAgence){
        return accountDAO.findAllByBranchId(codeAgence);
    }
    
    public void addClientToAccount(Client client, String accountId){
        Account account =  findById(accountId);
        account.getMesClients().add(client);
        accountDAO.update(account);
    }
    
}
