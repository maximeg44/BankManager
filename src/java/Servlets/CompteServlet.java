/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AccountDAO;
import DAO.ClientDAO;
import java.util.List;
import javax.servlet.http.HttpServlet;
import models.Compte;
import models.BankBranch;
import models.Client;

/**
 *
 * @author MGU
 */
public class CompteServlet extends HttpServlet {
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    
    
    public Compte createAccount(String[] infoAccount){
        Compte account = new Compte();
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));        
        accountDAO.create(account);
        return account;        
    }
    
    public Compte updateAccount(String[] infoAccount, String idAccount){
        Compte account = findById(idAccount);
        account.setIban(infoAccount[0]);
        account.setLibelle(infoAccount[1]);
        account.setSolde(new Double(infoAccount[2]));   
        accountDAO.update(account);
        
        return account;        
    }
    
    public Compte updateAccount(Compte account){
       accountDAO.update(account);
       return account;
       
    }
    
    public Compte findById(String id){
        return accountDAO.find(id);
    }
    
    public List<Compte> findAllAccounts(){
        return accountDAO.findAll();
    }
           
    public void removeAccount(Compte account){
        accountDAO.delete(account);
    }
    
    public List<Compte> findAllByBranchId(BankBranch branch){
        return accountDAO.findAllByBranchId(branch);
    }
    
    public void addClientToAccount(Client client, String accountId){
        Compte account =  findById(accountId);
        account.getMesClients().add(client);
        client.getMescomptes().add(account);
        accountDAO.update(account);
        ClientDAO.getInstance().update(client);
    }
    
}
